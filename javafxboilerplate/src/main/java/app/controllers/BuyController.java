package app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import app.domain.User;
import app.services.CustomerServiceStub;
import app.services.IOrderService_Order_OrderServiceFaultFault_FaultMessage;
import app.services.OrderServiceStub;
import app.services.ProductServiceStub;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class BuyController implements Initializable {
    @FXML private Button buyButton;
    @FXML private Text remainingBalance;
    @FXML private ListView<String> catalogBox;
    @FXML private ListView<String> inventoryBox;

    private ProductServiceStub.Product[] products;
    private double startingBalance = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.loadItems();
        this.setCustomerBal();
    }

    private void setCustomerBal() {
        try {
            CustomerServiceStub stub = new CustomerServiceStub();
            CustomerServiceStub.Find findFunction = new CustomerServiceStub.Find();

            findFunction.setId(User.userId);
            CustomerServiceStub.FindResponse findResponse = stub.find(findFunction);
            CustomerServiceStub.Customer customer = findResponse.getFindResult();

            this.startingBalance = customer.getBalance();
            remainingBalance.setText(String.valueOf(customer.getBalance()));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void setRemainingBalance() {
        double costs = 0;
        for (String inventoryItem: inventoryBox.getItems()) {
            String[] strings = inventoryItem.split(",");
            int amount = Integer.parseInt(strings[1].trim());

            int i;
            for (i = 0; i < this.products.length; i++) {
                if (this.products[i].getName().equals(strings[0])) {
                    costs += this.products[i].getPrice() * amount;
                }
            }
        }

        remainingBalance.setText(String.valueOf(this.startingBalance - costs));
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
            if (products != null) {
                for (i = 0; i < products.length; i++) {
                    ProductServiceStub.Product product = res.getAllResult().getProduct()[i];
                    catalogBox.getItems().add(product.getName() + ": €" + product.getPrice() + " Vooraad: " + product.getStock());
                }
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

            this.setRemainingBalance();
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

            this.setRemainingBalance();
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

            orderCall.setCustomerId(User.userId);
            orderCall.setStoreId(1);
            orderCall.setProducts(buyingProducts);

            orderServiceStub.order(orderCall);

            inventoryBox.getItems().clear();
            this.setCustomerBal();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bedankt voor u aankoop");
            alert.setHeaderText("Bedankt voor u aankoop");
            alert.showAndWait();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IOrderService_Order_OrderServiceFaultFault_FaultMessage e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(e.getFaultMessage().getOrderServiceFault().getMessage());
            alert.setHeaderText(e.getFaultMessage().getOrderServiceFault().getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    public void refresh() {
        this.loadItems();
    }

    @FXML
    public void toMe() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/me.fxml"));
        Parent registerPage = (Parent) fxmlLoader.load();
        Stage newStage = new Stage();
        newStage.setScene(new Scene(registerPage));
        newStage.show();

        Stage currentStage = (Stage) buyButton.getScene().getWindow();
        currentStage.close();
    }
}
