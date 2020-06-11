package main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.services.IOrderService_Order_OrderServiceFaultFault_FaultMessage;
import main.services.OrderServiceStub;
import main.services.ProductServiceStub;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class BuyController implements Initializable {
    @FXML private Button buyButton;
    @FXML private ListView<String> catalogBox;
    @FXML private ListView<String> inventoryBox;

    private ProductServiceStub.Product[] products;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.loadItems();
    }

    private void loadItems() {
        catalogBox.getItems().clear();

        try {
            ProductServiceStub stub = new ProductServiceStub();
            ProductServiceStub.All allFunction = new ProductServiceStub.All();
            ProductServiceStub.AllResponse res = stub.all(allFunction);

            ProductServiceStub.Product[] products = res.getAllResult().getProduct();

            this.products = products;

            int i;
            for (i = 0; i < products.length; i++) {
                ProductServiceStub.Product product = res.getAllResult().getProduct()[i];
                catalogBox.getItems().add(product.getName() + ": " + product.getPrice() + " Vooraad: " + product.getStock());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void removeFromInventory(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            String currentItemSelected = inventoryBox.getSelectionModel().getSelectedItem();
            String productName = currentItemSelected.split(",")[0];

            inventoryBox.getItems().remove(productName + ", 1");

            for (String inventoryItem: inventoryBox.getItems()) {
                String[] strings = inventoryItem.split(",");
                if (strings[0].equals(productName)) {
                    int index = inventoryBox.getItems().indexOf(inventoryItem);
                    inventoryBox.getItems().remove(index);
                    inventoryBox.getItems().add(index, productName + ", " + String.valueOf(Integer.parseInt(strings[1].trim()) - 1));
                }
            }
        }
    }

    @FXML
    public void addToInventory(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            String currentItemSelected = catalogBox.getSelectionModel().getSelectedItem();
            String productName = currentItemSelected.split(":")[0];

            boolean found = false;
            for (String inventoryItem: inventoryBox.getItems()) {
                String[] strings = inventoryItem.split(",");
                if (strings[0].equals(productName)) {
                    int index = inventoryBox.getItems().indexOf(inventoryItem);
                    inventoryBox.getItems().remove(index);
                    inventoryBox.getItems().add(index, productName + ", " + String.valueOf(Integer.parseInt(strings[1].trim()) + 1));
                    found = true;
                }
            }

            if (!found) {
                inventoryBox.getItems().add(productName + ", 1");
            }
        }
    }

    @FXML
    public void buy() {
        OrderServiceStub.ArrayOfBuyingProduct buyingProducts = new OrderServiceStub.ArrayOfBuyingProduct();

        for (String inventoryItem: inventoryBox.getItems()) {
            String[] strings = inventoryItem.split(",");
            int i;
            for (i = 0; i < this.products.length; i++) {
                if (this.products[i].getName().equals(strings[0])) {
                    OrderServiceStub.BuyingProduct buyingProduct = new OrderServiceStub.BuyingProduct();
                    buyingProduct.setId(this.products[i].getId());
                    buyingProduct.setAmount(Integer.parseInt(strings[1].trim()));
                    buyingProducts.addBuyingProduct(buyingProduct);
                }
            }
        }

        try {
            OrderServiceStub orderServiceStub = new OrderServiceStub();
            OrderServiceStub.Order orderCall = new OrderServiceStub.Order();

            // TODO set real id
            orderCall.setCustomerId(1);
            orderCall.setStoreId(1);
            orderCall.setProducts(buyingProducts);

            orderServiceStub.order(orderCall);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IOrderService_Order_OrderServiceFaultFault_FaultMessage e) {

            System.out.println("error");
            System.out.println(e.getFaultMessage().toString());
            // TODO show error message

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(e.getFaultMessage().toString());
        }
    }

    @FXML
    public void refresh() {
        this.loadItems();
    }

    @FXML
    public void toMe() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/me.fxml"));
        Parent registerPage = (Parent) fxmlLoader.load();
        Stage newStage = new Stage();
        newStage.setScene(new Scene(registerPage));
        newStage.show();

        Stage currentStage = (Stage) buyButton.getScene().getWindow();
        currentStage.close();
    }
}
