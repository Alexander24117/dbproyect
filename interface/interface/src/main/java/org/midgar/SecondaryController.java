package org.midgar;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.IOException;

public class SecondaryController {
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtPassword2;

    @FXML
    private Button btnRegister;


    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    public void validatePasswords() {
        String pass1 = "";
        String pass2 = "";


        pass1 = txtPassword.getText();
        pass2 = txtPassword2.getText();
        if (!pass1.equals(pass2) || txtName.getText().isEmpty() ||txtUserName.getText().isEmpty()) {
            btnRegister.setDisable(true);
           // txtconfirm.setDisable(false);
            System.out.println("Mal");
        } else {
            btnRegister.setDisable(false);
            //txtconfirm.setDisable(true);
            System.out.println("Bien");

        }

    }
}