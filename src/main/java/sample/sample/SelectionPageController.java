package sample.sample;
/**
 * @author Arkirka
 */
/**
 * Sample Skeleton for 'selectionPage.fxml' Controller Class
 */


import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;

public class SelectionPageController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="textIntput"
    private TextField textIntput; // Value injected by FXMLLoader

    @FXML // fx:id="textOutput"
    private TextArea textOutput; // Value injected by FXMLLoader

    @FXML // fx:id="buttonFind"
    private Button buttonFind; // Value injected by FXMLLoader

    @FXML // fx:id="buttonShift"
    private RadioButton buttonShift; // Value injected by FXMLLoader

    @FXML // fx:id="buttonWorker"
    private RadioButton buttonWorker; // Value injected by FXMLLoader

    @FXML
    void doFind(ActionEvent event) throws SQLException {
        Statement st = null;
        st = DB_connect.connection.createStatement();
        ResultSet rst = null;
        String result = "";
        if(buttonWorker.isSelected() && !buttonShift.isSelected()) {
            rst = st.executeQuery("SELECT * FROM рабочие WHERE " + textIntput.getText() + ";");
            while (rst.next()) {
                result += rst.getString(1) +" " + rst.getString(2) + " " + rst.getString(3) + "\n";
            }
            textOutput.setText(result);
        } else if(!buttonWorker.isSelected() && buttonShift.isSelected()) {
            rst = st.executeQuery("SELECT * FROM наряды_рабочих WHERE " + textIntput.getText() + ";");
            while (rst.next()) {
                result += rst.getString(1) +" " + rst.getString(2) + " " + rst.getString(3) + " " + rst.getString(4) + " " + rst.getString(5) + " " + rst.getString(6) + " " + rst.getString(7) + "\n";
            }
            textOutput.setText(result);
        } else if(buttonWorker.isSelected() && buttonShift.isSelected()) {
            rst = st.executeQuery("SELECT * FROM наряды_рабочих, рабочие WHERE " + textIntput.getText() + ";");
            while (rst.next()) {
                result += rst.getString(1) +" " + rst.getString(2) + " " + rst.getString(3) + " " + rst.getString(4) +" " + rst.getString(5) + " " + rst.getString(6) + " " + rst.getString(7) + " " + rst.getString(8) + " " + rst.getString(9) + " " + rst.getString(10) + "\n";
            }
            textOutput.setText(result);
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert textIntput != null : "fx:id=\"textIntput\" was not injected: check your FXML file 'selectionPage.fxml'.";
        assert textOutput != null : "fx:id=\"textOutput\" was not injected: check your FXML file 'selectionPage.fxml'.";
        assert buttonFind != null : "fx:id=\"buttonFind\" was not injected: check your FXML file 'selectionPage.fxml'.";
        assert buttonShift != null : "fx:id=\"buttonShift\" was not injected: check your FXML file 'selectionPage.fxml'.";
        assert buttonWorker != null : "fx:id=\"buttonWorker\" was not injected: check your FXML file 'selectionPage.fxml'.";

    }
}
