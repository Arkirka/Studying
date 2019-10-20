package sample.sample;

/**
 * Sample Skeleton for 'dbSettingsPage.fxml' Controller Class
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Button;

public class dbSettingsPageController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="subScene"
    private SubScene subScene; // Value injected by FXMLLoader

    @FXML // fx:id="buttonDeleteEntry"
    private Button buttonDeleteEntry; // Value injected by FXMLLoader

    @FXML // fx:id="buttonAddEntry"
    private Button buttonAddEntry; // Value injected by FXMLLoader

    @FXML // fx:id="buttonEditEntry"
    private Button buttonEditEntry; // Value injected by FXMLLoader

    @FXML
    void toAddPage(ActionEvent event) throws IOException {
        subScene.setVisible(true);
        Parent root = FXMLLoader.load(getClass().getResource("/addScene.fxml"));
        subScene.setRoot(root);
    }

    @FXML
    void toEditPage(ActionEvent event) throws IOException {
        subScene.setVisible(true);
        Parent root = FXMLLoader.load(getClass().getResource("/editScene.fxml"));
        subScene.setRoot(root);
    }

    @FXML
    void toDeletePage(ActionEvent event) throws IOException {
        subScene.setVisible(true);
        Parent root = FXMLLoader.load(getClass().getResource("/deleteScene.fxml"));
        subScene.setRoot(root);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert subScene != null : "fx:id=\"subScene\" was not injected: check your FXML file 'dbSettingsPage.fxml'.";
        assert buttonDeleteEntry != null : "fx:id=\"buttonDeleteEntry\" was not injected: check your FXML file 'dbSettingsPage.fxml'.";
        assert buttonAddEntry != null : "fx:id=\"buttonAddEntry\" was not injected: check your FXML file 'dbSettingsPage.fxml'.";
        assert buttonEditEntry != null : "fx:id=\"buttonEditEntry\" was not injected: check your FXML file 'dbSettingsPage.fxml'.";

    }
}

