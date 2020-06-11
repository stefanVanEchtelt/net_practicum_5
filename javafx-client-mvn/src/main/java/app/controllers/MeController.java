package app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import app.domain.User;
import app.services.CustomerServiceStub;
import app.services.CustomerServiceStub.Find;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class MeController implements Initializable {
    @FXML private Text balance;
    @FXML private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            CustomerServiceStub stub = new CustomerServiceStub();
            Find findFunction = new Find();

            findFunction.setId(User.userId);
            CustomerServiceStub.FindResponse findResponse = stub.find(findFunction);
            CustomerServiceStub.Customer customer = findResponse.getFindResult();

            balance.setText(String.valueOf(customer.getBalance()));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void toBoughtProducts() throws IOException {
        redirectToPage("boughtProducts");
    }

    @FXML
    public void toBuy() throws IOException {
        redirectToPage("buy");
    }

    private void redirectToPage(String pageName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/" + pageName + ".fxml"));
        Parent registerPage = (Parent) fxmlLoader.load();
        Stage newStage = new Stage();
        newStage.setScene(new Scene(registerPage));
        newStage.show();

        Stage currentStage = (Stage) backButton.getScene().getWindow();
        currentStage.close();
    }
}
