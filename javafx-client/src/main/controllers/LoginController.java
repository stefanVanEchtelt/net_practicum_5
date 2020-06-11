package main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import main.domain.User;
import main.services.CustomerServiceStub;
import main.services.ICustomerService_LoginCustomer_CustomerFaultServiceFault_FaultMessage;

import java.io.IOException;
import java.rmi.RemoteException;

public class LoginController {
    @FXML private Button loginButton;
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;

    @FXML
    public void login() throws IOException {
        try {
            CustomerServiceStub stub = new CustomerServiceStub();
            CustomerServiceStub.LoginCustomer loginCustomerCall = new CustomerServiceStub.LoginCustomer();
            loginCustomerCall.setUsername(usernameField.getText());
            loginCustomerCall.setPassword(passwordField.getText());

            CustomerServiceStub.LoginCustomerResponse loginCustomerResponse = stub.loginCustomer(loginCustomerCall);

            if (loginCustomerResponse.getLoginCustomerResult() != null) {
                User.userId = loginCustomerResponse.getLoginCustomerResult().getId();
                redirectToPage("buy");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Foute login");
                alert.setHeaderText("Foute login");
                alert.showAndWait();
            }
        } catch (RemoteException | ICustomerService_LoginCustomer_CustomerFaultServiceFault_FaultMessage e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void to_register() throws IOException {
        redirectToPage("register");
    }

    private void redirectToPage(String pageName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/" + pageName + ".fxml"));
        Parent registerPage = (Parent) fxmlLoader.load();
        Stage newStage = new Stage();
        newStage.setScene(new Scene(registerPage));
        newStage.show();

        Stage currentStage = (Stage) loginButton.getScene().getWindow();
        currentStage.close();
    }
}
