package app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import app.services.CustomerServiceStub;
import app.services.ICustomerService_LoginCustomer_CustomerFaultServiceFault_FaultMessage;

public class RegisterController {
    @FXML private Button registerButton;
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;

    @FXML
    public void register() throws IOException {
        try {
            CustomerServiceStub stub = new CustomerServiceStub();
            CustomerServiceStub.RegisterCustomer registerCustomerCall = new CustomerServiceStub.RegisterCustomer();
            registerCustomerCall.setUsername(usernameField.getText());

            CustomerServiceStub.RegisterCustomerResponse loginCustomerResponse = stub.registerCustomer(registerCustomerCall);
            passwordField.setText(loginCustomerResponse.getRegisterCustomerResult().getPassword());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vergeet niet het wachtwoord op te slaan!");
            // if (loginCustomerResponse.getLoginCustomerResult() != null) {
            //     User.userId = loginCustomerResponse.getLoginCustomerResult().getId();
            //     redirectToPage("buy");
            // } else {
            //     Alert alert = new Alert(Alert.AlertType.ERROR);
            //     alert.setTitle("Foute login");
            //     alert.setHeaderText("Foute login");
            //     alert.showAndWait();
            // }
        } catch (Exception e) {
        // } catch (RemoteException | ICustomerService_LoginCustomer_CustomerFaultServiceFault_FaultMessage e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void to_login() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Parent registerPage = (Parent) fxmlLoader.load();
        Stage newStage = new Stage();
        newStage.setScene(new Scene(registerPage));
        newStage.show();

        Stage currentStage = (Stage) registerButton.getScene().getWindow();
        currentStage.close();
    }

    private void redirectToPage(String pageName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/" + pageName + ".fxml"));
        Parent registerPage = (Parent) fxmlLoader.load();
        Stage newStage = new Stage();
        newStage.setScene(new Scene(registerPage));
        newStage.show();

        Stage currentStage = (Stage) registerButton.getScene().getWindow();
        currentStage.close();
    }
}
