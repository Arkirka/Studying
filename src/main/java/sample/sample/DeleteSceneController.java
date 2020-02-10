package sample.sample;
/**
 * @author Arkirka
 */
/**
 * Sample Skeleton for 'deleteScene.fxml' Controller Class
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

public class DeleteSceneController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="textID"
        private TextField textID; // Value injected by FXMLLoader

    @FXML // fx:id="buttonDelete"
    private Button buttonDelete; // Value injected by FXMLLoader

    @FXML // fx:id="buttonW"
    private RadioButton buttonW; // Value injected by FXMLLoader

    @FXML // fx:id="labelDeleted"
    private Label labelDeleted; // Value injected by FXMLLoader

    @FXML // fx:id="buttonWO"
    private RadioButton buttonWO; // Value injected by FXMLLoader

    @FXML
    void deleteEntry(ActionEvent event) throws SQLException {
        if(buttonW.isSelected()) {
            String query = "DELETE FROM рабочие WHERE id = '" + textID.getText() + "';";
            Statement stmt = null;
            stmt = DB_connect.connection.createStatement();
            stmt.executeUpdate(query);
        }
        if (buttonWO.isSelected()) {
            String query = "DELETE FROM наряды_рабочих WHERE id = '" + textID.getText() + "';";
            Statement stmt = null;
            stmt = DB_connect.connection.createStatement();
            stmt.executeUpdate(query);
        }
        labelDeleted.setText("Запись удалена");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert textID != null : "fx:id=\"textID\" was not injected: check your FXML file 'deleteScene.fxml'.";
        assert buttonDelete != null : "fx:id=\"buttonDelete\" was not injected: check your FXML file 'deleteScene.fxml'.";
        assert buttonW != null : "fx:id=\"buttonW\" was not injected: check your FXML file 'deleteScene.fxml'.";
        assert labelDeleted != null : "fx:id=\"labelDeleted\" was not injected: check your FXML file 'deleteScene.fxml'.";
        assert buttonWO != null : "fx:id=\"buttonWO\" was not injected: check your FXML file 'deleteScene.fxml'.";

    }
}
