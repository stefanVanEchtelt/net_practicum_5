package main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BuyController implements Initializable {
    @FXML private Button buyButton;
    @FXML private ListView<String> itemBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.loadItems();
    }

    private void loadItems() {
        // TODO make refresh of products
        itemBox.getItems().clear();

        itemBox.getItems().add("Item 1");
        itemBox.getItems().add("Item 2");

//        try {
//            ProductServiceStub stub = new ProductServiceStub();
//            ProductServiceStub.All allFunction = new ProductServiceStub.All();
//            ProductServiceStub.AllResponse res = stub.all(allFunction);
//
//            ProductServiceStub.Product[] products = res.getAllResult().getProduct();
//
//            int i;
//            for (i = 0; i < products.length; i++) {
//                ProductServiceStub.Product product = res.getAllResult().getProduct()[i];
//                itemBox.getItems().add(product.getName());
//                System.out.println(product.getName());
//            }
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
    }

    @FXML
    public void buy() {
        // TODO make buy page
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
