package app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import app.domain.User;
import app.services.OrderLineServiceStub;
import app.services.OrderLineServiceStub.BoughtProduct;
import app.services.OrderLineServiceStub.PerProductByCustomer;
import app.services.OrderLineServiceStub.PerProductByCustomerResponse;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class BoughtProductsController implements Initializable {
    @FXML private Button backButton;
    @FXML private TableView<BoughtProduct> boughtProductTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn nameColumn = new TableColumn("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn amountColumn = new TableColumn("Amount");
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        this.boughtProductTableView.getColumns().addAll(nameColumn, amountColumn);

        try {
            OrderLineServiceStub stub = new OrderLineServiceStub();
            PerProductByCustomer perProductByCustomer = new PerProductByCustomer();

            perProductByCustomer.setCustomerId(User.userId);
            PerProductByCustomerResponse response = stub.perProductByCustomer(perProductByCustomer);

            BoughtProduct[] boughtProducts = response.getPerProductByCustomerResult().getBoughtProduct();

            int i;
            for (i = 0; i < boughtProducts.length; i++) {
                BoughtProduct boughtProduct = boughtProducts[i];
                this.boughtProductTableView.getItems().add(boughtProduct);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void toMe() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/me.fxml"));
        Parent registerPage = (Parent) fxmlLoader.load();
        Stage newStage = new Stage();
        newStage.setScene(new Scene(registerPage));
        newStage.show();

        Stage currentStage = (Stage) backButton.getScene().getWindow();
        currentStage.close();
    }
}
