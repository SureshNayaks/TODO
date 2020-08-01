package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Database.DatabaseHandler;
import sample.model.Users;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Firstname;

    @FXML
    private TextField Lastname;

    @FXML
    private TextField Location;

    @FXML
    private TextField Username;

    @FXML
    private CheckBox Malecheckbox;

    @FXML
    private CheckBox Femalecheckbox;

    @FXML
    private Button Signupbtn;

    @FXML
    private PasswordField Signpassword;

    @FXML
    void initialize() {


        Signupbtn.setOnAction(event -> {
            CreateUser();
        });
    }

    public void CreateUser(){

        DatabaseHandler databaseHandler = new DatabaseHandler();


        String name = Firstname.getText();
        String lastname = Lastname.getText();
        String username = Username.getText();
        String password = Signpassword.getText();
        String location = Location.getText();

        String gender = "";
        if (Femalecheckbox.isSelected()){
            gender ="female";
        }else{
            gender="male";
        }

        Users user = new Users(name,lastname,username,password,location,gender);

        databaseHandler.UserSignup(user);

    }
}
