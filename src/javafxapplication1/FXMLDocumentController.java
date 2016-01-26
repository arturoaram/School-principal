/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Arturo
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Button button;    
    Parent root;
    @FXML
    TextField usernameTextfield;
    @FXML
    PasswordField passwordTextfield;
    
    @FXML
    private void LoginButtonn(ActionEvent event) throws IOException {
        
        
        
        if(usernameTextfield.getText().equals("jorge") && passwordTextfield.getText().equals("principal")){
        Stage stage = (Stage) button.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        
        else{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Problem");
        alert.setHeaderText(null);
        alert.setContentText("\t\t\tIncorrect Information\n"+"\t\t\t          Try again!");

        alert.showAndWait();
        
        usernameTextfield.clear();
        passwordTextfield.clear();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
