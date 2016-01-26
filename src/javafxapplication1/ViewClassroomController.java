/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Arturo
 */
public class ViewClassroomController implements Initializable {
    @FXML
    private Button cancelClassroom;
    @FXML
    private Button viewEditButton;
    private Parent root;
    @FXML
    private ListView listView;
        
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        List<String> values = Arrays.asList("Classroom 15", "Classroom 05", "Classroom 2");        
        listView.setItems(FXCollections.observableList(values));
    }    

    @FXML
    private void cancelClassroomButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancelClassroom.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML private void viewEditClassroomButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) viewEditButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("EditClassroom.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    
}
