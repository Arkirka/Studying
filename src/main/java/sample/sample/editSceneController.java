package sample.sample;

/**
 * Sample Skeleton for 'editScene.fxml' Controller Class
 */


import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class editSceneController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="textID"
    private TextField textID; // Value injected by FXMLLoader

    @FXML // fx:id="textEdit"
    private TextField textEdit; // Value injected by FXMLLoader

    @FXML // fx:id="buttonEdit"
    private Button buttonEdit; // Value injected by FXMLLoader

    @FXML // fx:id="buttonW"
    private RadioButton buttonW; // Value injected by FXMLLoader

    @FXML // fx:id="labelEdited"
    private Label labelEdited; // Value injected by FXMLLoader

    @FXML // fx:id="textColumn"
    private TextField textColumn; // Value injected by FXMLLoader

    @FXML // fx:id="buttonWO"
    private RadioButton buttonWO; // Value injected by FXMLLoader

    @FXML
    void editEnry(ActionEvent event) throws SQLException {
        if (buttonW.isSelected()) {
            String query = "UPDATE рабочие SET " + textColumn.getText() + " = '" + textEdit.getText() +
                    "' WHERE id = '" + textID.getText() + "';";
            Statement stmt = null;
            stmt = DB_connect.connection.createStatement();
            stmt.executeUpdate(query);
        }
        if (buttonWO.isSelected()) {
            String query = "UPDATE наряды_рабочих SET " + textColumn.getText() + " = '" + textEdit.getText() +
                    "' WHERE id = '" + textID.getText() + "';";
            Statement stmt = null;
            stmt = DB_connect.connection.createStatement();
            stmt.executeUpdate(query);
        }
        labelEdited.setText("Запись изменена");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert textID != null : "fx:id=\"textID\" was not injected: check your FXML file 'editScene.fxml'.";
        assert textEdit != null : "fx:id=\"textEdit\" was not injected: check your FXML file 'editScene.fxml'.";
        assert buttonEdit != null : "fx:id=\"buttonEdit\" was not injected: check your FXML file 'editScene.fxml'.";
        assert buttonW != null : "fx:id=\"buttonW\" was not injected: check your FXML file 'editScene.fxml'.";
        assert labelEdited != null : "fx:id=\"labelEdited\" was not injected: check your FXML file 'editScene.fxml'.";
        assert textColumn != null : "fx:id=\"textColumn\" was not injected: check your FXML file 'editScene.fxml'.";
        assert buttonWO != null : "fx:id=\"buttonWO\" was not injected: check your FXML file 'editScene.fxml'.";

    }
}
