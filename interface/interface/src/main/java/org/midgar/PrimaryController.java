package org.midgar;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PrimaryController {
    @FXML
    private TextField txtuserName;
    @FXML
    private  TextField txtpassword;
    @FXML
    private Button btnLogin;

    @FXML
    private void signIn() throws IOException {
        App.setRoot("secondary");

    }


    @FXML
    private void getLogin(){
        try {
            String userNamee = txtuserName.getText();
            String passwords = txtpassword.getText();
            System.out.println(userNamee +" " + passwords);
        }catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
        }

    }
}
