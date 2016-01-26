/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static javafxapplication1.JavaFXApplication1.main;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * FXML Controller class
 *
 * @author Arturo
 */
public class CreateClassroommController implements Initializable {

    @FXML
    Button cancel;
    Parent root;
    @FXML
    Button submitClassroomButton;
    @FXML
    ListView<String> allStudentsList;
    @FXML
    ListView<String> classroomStudentsList;
    @FXML
    ComboBox<String> teachersComboBox;
    @FXML
    TextField capacityTextfield;
    @FXML
    TextField classroomNameTextfield;
    Classroom classroom;
    final ObservableList<String> listItems = FXCollections.observableArrayList();
    final ObservableList<String> listItemsStudents = FXCollections.observableArrayList();
    File file = new File("D:\\Documents\\NetBeans\\JavaFXApplication1\\src\\javafxapplication1\\XML.xml");
    OutputStream os;

    Classroom[] classroomArray;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        listItems.addAll("Maria", "Pedro", "Juan", "Sofia", "Jose", "Curtis", "Lauren", "Sophia");

        allStudentsList.setItems(FXCollections.observableList(listItems));

        classroomStudentsList.setItems(FXCollections.observableList(listItemsStudents));

        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "Alfonso Ramirez",
                        "Margarita Ureña",
                        "Laura Salcedo",
                        "Hector Valdez",
                        "Victor Castillos"
                );
        teachersComboBox.setItems(FXCollections.observableArrayList(options));
    }

    //
    @FXML
    private void cancelCreateClassroom(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancel.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void submitClassroom(ActionEvent event) throws IOException {
        String s = capacityTextfield.getText();
        int capacity = Integer.parseInt(s);
        String teacher = teachersComboBox.getValue();
        String name = classroomNameTextfield.getText();
        String[] arr = listItemsStudents.toArray(new String[listItemsStudents.size()]);

        classroom = new Classroom();
        classroom.setName(name);
        classroom.setCapacity(capacity);
        classroom.setTeacher(teacher);
        classroom.setStudents(arr);
        //classroom = new Classroom(name,capacity,teacher,arr);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Feedback Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Classroom Created!");

        alert.showAndWait();

        Stage stage = (Stage) submitClassroomButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        
        
        
        

        try {
            
            JAXBContext jaxbContext = JAXBContext.newInstance(Classroom.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(classroom, file);

            jaxbMarshaller.marshal(classroom, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void addStudentsToCurrentList(ActionEvent event) throws IOException {

        int selectedIndex = allStudentsList.getSelectionModel().getSelectedIndex();
        String s = allStudentsList.getSelectionModel().getSelectedItem();

        if (selectedIndex >= 0) {

            listItemsStudents.add(s);

            listItems.remove(allStudentsList.getSelectionModel().getSelectedIndex());
            allStudentsList.setItems(FXCollections.observableList(listItems));
            classroomStudentsList.setItems(FXCollections.observableList(listItemsStudents));
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Index not selected");
            alert.setContentText("Please select a name and try again!");

            alert.showAndWait();
        }

    }

    @FXML
    private void removeStudentsFromCurrentList(ActionEvent event) throws IOException {
        int selectedIndex = classroomStudentsList.getSelectionModel().getSelectedIndex();
        String s = classroomStudentsList.getSelectionModel().getSelectedItem();

        if (selectedIndex >= 0) {

            listItems.add(s);

            listItemsStudents.remove(selectedIndex);
            allStudentsList.setItems(FXCollections.observableList(listItems));
            classroomStudentsList.setItems(FXCollections.observableList(listItemsStudents));
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Index not selected");
            alert.setContentText("Please select a name and try again!");

            alert.showAndWait();
        }

    }

    public File getPersonFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(CreateClassroommController.class);
        String filePath = prefs.get("D:\\Documents\\NetBeans\\JavaFXApplication1\\src\\javafxapplication1\\XML.xml", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    public void setPersonFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(CreateClassroommController.class);
        if (file != null) {
            prefs.put("D:\\Documents\\NetBeans\\JavaFXApplication1\\src\\javafxapplication1\\XML.xml", file.getPath());

        // Update the stage title.
            //primaryStage.setTitle("AddressApp - " + file.getName());
        } else {
            prefs.remove("D:\\Documents\\NetBeans\\JavaFXApplication1\\src\\javafxapplication1\\XML.xml");

        // Update the stage title.
            //primaryStage.setTitle("AddressApp");
        }
    }

}
