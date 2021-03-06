package main.com.ceng453.client.pagecontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IndexController extends PageController{

    @FXML
    Button login;  // When this button is clicked User is directed to Log In page
    @FXML
    Button register;  // When this button is clicked User is directed to Register page
    @FXML
    Button leaderBoard; // When this button is clicked User is directed to LeaderBoard page

    private void loginHandler(ActionEvent actionEvent){
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        changeScene();
    }

    private void registerHandler(ActionEvent actionEvent){
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/Register.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        changeScene();
    }

    private void leaderBoardHandler(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/LeaderBoard.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        changeScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login.setOnAction(this::loginHandler);
        register.setOnAction(this::registerHandler);
        leaderBoard.setOnAction(this::leaderBoardHandler);
    }
}

