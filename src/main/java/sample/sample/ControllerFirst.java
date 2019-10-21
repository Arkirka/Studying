/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

package sample.sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static sample.sample.Main.*;

public class ControllerFirst {

    DB_connect fxConnection = null;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="ConnectBut"
    private Button ConnectBut; // Value injected by FXMLLoader

    @FXML // fx:id="infoLabel"
    private Label infoLabel; // Value injected by FXMLLoader

    @FXML // fx:id="transitionBut"
    private Button transitionBut; // Value injected by FXMLLoader

    @FXML // fx:id="buttonConnectSettings"
    private Button buttonConnectSettings; // Value injected by FXMLLoader

    static private Stage settingsWindow = null;

    @FXML
    void connectDB(ActionEvent event)
    {
        fxConnection = new DB_connect();
        if (fxConnection.connected)
        {
            infoLabel.setText("Database Connection Established...");
            transitionBut.setDisable(false);
        } else
        {
            infoLabel.setText("Connection failed");
        }
    }

    @FXML
    void toConnectSettings(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/pageConnectSettings.fxml"));
            settingsWindow = new Stage();
            settingsWindow.setScene(new Scene(root, 549, 359));
            settingsWindow.show();
        } catch (IOException er) {
            er.printStackTrace();
        }
    }

    @FXML
    void goDBScene(ActionEvent event) {
        if (fxConnection.connected)
        {
            setFxUrl("/dbPage.fxml");
            try {
                Parent root = FXMLLoader.load(getClass().getResource(getFxUrl()));
                getStage().setScene(new Scene(root, 934, 586));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
        {
            infoLabel.setText("Error");
        }
    }

    public Stage getSettingsWindow() {
        return settingsWindow;
    }

    public void setSettingsWindow(Stage settingsWindow) {
        this.settingsWindow = settingsWindow;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert ConnectBut != null : "fx:id=\"ConnectBut\" was not injected: check your FXML file 'sample.fxml'.";
        assert infoLabel != null : "fx:id=\"infoLabel\" was not injected: check your FXML file 'sample.fxml'.";
        assert transitionBut != null : "fx:id=\"transitionBut\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
