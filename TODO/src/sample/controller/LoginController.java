package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Animations.Shaker;
import sample.Database.DatabaseHandler;
import sample.model.Users;


public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField LoginUsername;

    @FXML
    private PasswordField LoginPassword;

    @FXML
    private Button Loginbtn;

    @FXML
    private Button Loginsignupbtn;

    private DatabaseHandler databaseHandler;

    @FXML
    void initialize() {

        databaseHandler = new DatabaseHandler();
        Loginbtn.setOnAction(event -> {
            String loginusernametext  = LoginUsername.getText().trim();
            String loginpasswordtext  = LoginPassword.getText().trim();


            Users user = new Users();
            user.setUserName(loginusernametext);
            user.setPassword(loginpasswordtext);
            ResultSet userRow = databaseHandler.loginuser(user);
            int Counter  = 0;
            try {
                while (userRow.next()){
                    Counter++;
                    String firstname = userRow.getString("firstname");
                    System.out.println("login successful "+firstname);
                }
                if (Counter==1){
                    additemscreen();
                }
                else{
                    Shaker usernameshaker = new
                            Shaker(LoginUsername);
                    Shaker passwordshaker = new Shaker(LoginPassword);
                    usernameshaker.shake();
                    passwordshaker.shake();

                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        });

        Loginsignupbtn.setOnAction(event -> {
            //Take user to the sign up page
            Loginsignupbtn.getScene().getWindow().hide();
            //cofirmed the page and move forward
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/Signup.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
    public void additemscreen(){
        Loginsignupbtn.getScene().getWindow().hide();
        //cofirmed the page and move forward
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/additem.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }



}
