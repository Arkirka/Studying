package sample.sample;

/**
 * Sample Skeleton for 'valuePage.fxml' Controller Class
 */


import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class valuePageController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="totalAmount"
    private Button totalAmount; // Value injected by FXMLLoader

    @FXML // fx:id="average"
    private Button average; // Value injected by FXMLLoader

    @FXML // fx:id="count"
    private Button count; // Value injected by FXMLLoader

    @FXML // fx:id="outputText"
    private TextArea outputText; // Value injected by FXMLLoader

    @FXML
    void doCount(ActionEvent event) throws SQLException {
        Statement st = null;
        st = DB_connect.connection.createStatement();
        ResultSet rst = null;
        rst = st.executeQuery("SELECT COUNT(*) FROM наряды_рабочих;");
        while (rst.next()) {
            outputText.setText(String.valueOf(rst.getInt(1)));
        }

    }

    @FXML
    void doTotalAmount(ActionEvent event) throws SQLException {
        int iCount = 0;
        Statement st = null;
        st = DB_connect.connection.createStatement();
        ResultSet rst = null;
        rst = st.executeQuery("SELECT сумма FROM наряды_рабочих;");
        while (rst.next()) {
            iCount = iCount + rst.getInt(1);
        }
        String iS = " " + iCount;
        outputText.setText(iS);
    }

    @FXML
    void doAveage(ActionEvent event) throws SQLException {
        Statement st = null;
        st = DB_connect.connection.createStatement();
        ResultSet rst = null;
        rst = st.executeQuery("SELECT AVG(расценка) FROM наряды_рабочих;");
        while (rst.next()) {
            outputText.setText(String.valueOf(rst.getInt(1)));
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert totalAmount != null : "fx:id=\"totalAmount\" was not injected: check your FXML file 'valuePage.fxml'.";
        assert average != null : "fx:id=\"average\" was not injected: check your FXML file 'valuePage.fxml'.";
        assert count != null : "fx:id=\"count\" was not injected: check your FXML file 'valuePage.fxml'.";
        assert outputText != null : "fx:id=\"outputText\" was not injected: check your FXML file 'valuePage.fxml'.";

    }
}
