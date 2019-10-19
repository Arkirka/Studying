package sample.sample;

/**
 * Sample Skeleton for 'pageConnectSettings.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PageConnectSettingsController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="textName"
    private TextField textName; // Value injected by FXMLLoader

    @FXML // fx:id="textPassword"
    private TextField textPassword; // Value injected by FXMLLoader

    @FXML // fx:id="textSocket"
    private TextField textSocket; // Value injected by FXMLLoader

    @FXML // fx:id="textPort"
    private TextField textPort; // Value injected by FXMLLoader

    @FXML // fx:id="buttonChangeConnect"
    private Button buttonChangeConnect; // Value injected by FXMLLoader

    @FXML // fx:id="textHost"
    private TextField textHost; // Value injected by FXMLLoader


    @FXML // fx:id="textSchema"
    private TextField textSchema; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSetDefault"
    private Button buttonSetDefault; // Value injected by FXMLLoader

    @FXML
    void setDefault(ActionEvent event) {
        textHost.setText("localhost");
        textSocket.setText("MySQL");
        textPort.setText("3306");
    }

    @FXML
    void changeConnect(ActionEvent event) {
        DB_connect.setHost(textHost.getText());
        DB_connect.setSocket(textSocket.getText());
        DB_connect.setPort(textPort.getText());
        DB_connect.setDB_UName(textName.getText());
        DB_connect.setDB_UPassword(textPassword.getText());
        DB_connect.setSchema(textSchema.getText());

        ControllerFirst controllerFirst = new ControllerFirst();
        controllerFirst.getSettingsWindow().close();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert textSocket != null : "fx:id=\"textSocket\" was not injected: check your FXML file 'pageConnectSettings.fxml'.";
        assert textPort != null : "fx:id=\"textPort\" was not injected: check your FXML file 'pageConnectSettings.fxml'.";
        assert buttonChangeConnect != null : "fx:id=\"buttonChangeConnect\" was not injected: check your FXML file 'pageConnectSettings.fxml'.";
        assert textHost != null : "fx:id=\"textHost\" was not injected: check your FXML file 'pageConnectSettings.fxml'.";
        assert buttonSetDefault != null : "fx:id=\"buttonSetDefault\" was not injected: check your FXML file 'pageConnectSettings.fxml'.";

    }
}
