package sample.controller;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import sample.Animations.Shaker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdditemController {

    @FXML
    private AnchorPane rootanchorpane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Additembtn;

    @FXML
    private Label noitemlabel;

    @FXML
    void initialize() {
        Additembtn.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> {
            FadeTransition fadeTransition  = new FadeTransition(Duration.millis(4000),Additembtn);
            FadeTransition labelTransition = new FadeTransition(Duration.millis(4000),noitemlabel);
            System.out.println("add button clicked");

            Additembtn.relocate(0,20);
            noitemlabel.relocate(0,40);

            Additembtn.setOpacity(0);
            noitemlabel.setOpacity(0);


            fadeTransition.setFromValue(1f);
            fadeTransition.setToValue(0f);
            fadeTransition.setCycleCount(1);
            fadeTransition.setAutoReverse(false);
            fadeTransition.play();

            fadeTransition.setByValue(1f);
            fadeTransition.setToValue(0f);
            fadeTransition.setCycleCount(1);
            fadeTransition.setAutoReverse(false);
            fadeTransition.play();

            try {
                AnchorPane formpane = FXMLLoader.load(getClass().getResource("/sample/view/additemform.fxml"));

                FadeTransition formpanetrans = new FadeTransition(Duration.millis(4000),rootanchorpane);
                formpanetrans.setFromValue(0f);
                formpanetrans.setToValue(1f);
                formpanetrans.setCycleCount(1);
                formpanetrans.setAutoReverse(false);
                formpanetrans.play();

                rootanchorpane.getChildren().setAll(formpane);

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}
