package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddItemFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField additemformtask;

    @FXML
    private TextField additemformdescription;

    @FXML
    private Button additemFormaddtaskbtn;

    @FXML
    void initialize() {

        additemFormaddtaskbtn.setOnAction(event -> {
            System.out.println("clicked");
        });

    }
}
