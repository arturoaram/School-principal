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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Arturo
 */


public class FXMLController implements Initializable {
    @FXML
    private Button viewButton;
    @FXML
    Parent root;
    @FXML
    private void ViewClassroomButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) viewButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ViewClassroom.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
