package sample.sample;

/**
 * Sample Skeleton for 'addScene.fxml' Controller Class
 */


import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddSceneController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="buttonAddEntryWO"
    private Button buttonAddEntryWO; // Value injected by FXMLLoader

    @FXML // fx:id="textMnCount"
    private TextField textMnCount; // Value injected by FXMLLoader

    @FXML // fx:id="textNumWrkshW"
    private TextField textNumWrkshW; // Value injected by FXMLLoader

    @FXML // fx:id="textPriceAll"
    private TextField textPriceAll; // Value injected by FXMLLoader

    @FXML // fx:id="textMonth"
    private TextField textMonth; // Value injected by FXMLLoader

    @FXML // fx:id="textNumWrkshWO"
    private TextField textNumWrkshWO; // Value injected by FXMLLoader

    @FXML // fx:id="labelAddWO"
    private Label labelAddWO; // Value injected by FXMLLoader

    @FXML // fx:id="labelAddW"
    private Label labelAddW; // Value injected by FXMLLoader

    @FXML // fx:id="textSFP"
    private TextField textSFP; // Value injected by FXMLLoader

    @FXML // fx:id="buttonAddEntryW"
    private Button buttonAddEntryW; // Value injected by FXMLLoader

    @FXML // fx:id="textTechOper"
    private TextField textTechOper; // Value injected by FXMLLoader

    @FXML // fx:id="textPrice"
    private TextField textPrice; // Value injected by FXMLLoader

    @FXML
    void addEntryW(ActionEvent event) throws SQLException {

        String query = "INSERT INTO workshop.рабочие (ФИО, №_цеха) " +
                " VALUES ('"+ textSFP.getText() + "' , '" + textNumWrkshW.getText() + "');";

        Statement stmt = null;
        stmt = DB_connect.connection.createStatement();
        stmt.executeUpdate(query);
        labelAddW.setText("Запись добавлена");
    }

    @FXML
    void addEntryWO(ActionEvent event) throws SQLException {
        String query = "INSERT INTO workshop.наряды_рабочих (№_цеха, месяц, техОперация, количество, расценка, сумма) " +
                " VALUES ('"+ textNumWrkshWO.getText() + "' , '" + textMonth.getText() + "' , '" + textTechOper.getText() +
                "' , '"+ textMnCount.getText() + "' , '"+ textPrice.getText() + "' , '"+ textPriceAll.getText() + "');";

        Statement stmt = null;
        stmt = DB_connect.connection.createStatement();
        stmt.executeUpdate(query);
        labelAddWO.setText("Запись добавлена");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert buttonAddEntryWO != null : "fx:id=\"buttonAddEntryWO\" was not injected: check your FXML file 'addScene.fxml'.";
        assert textMnCount != null : "fx:id=\"textMnCount\" was not injected: check your FXML file 'addScene.fxml'.";
        assert textNumWrkshW != null : "fx:id=\"textNumWrkshW\" was not injected: check your FXML file 'addScene.fxml'.";
        assert textPriceAll != null : "fx:id=\"textPriceAll\" was not injected: check your FXML file 'addScene.fxml'.";
        assert textMonth != null : "fx:id=\"textMonth\" was not injected: check your FXML file 'addScene.fxml'.";
        assert textNumWrkshWO != null : "fx:id=\"textNumWrkshWO\" was not injected: check your FXML file 'addScene.fxml'.";
        assert textSFP != null : "fx:id=\"textSFP\" was not injected: check your FXML file 'addScene.fxml'.";
        assert buttonAddEntryW != null : "fx:id=\"buttonAddEntryW\" was not injected: check your FXML file 'addScene.fxml'.";
        assert textTechOper != null : "fx:id=\"textTechOper\" was not injected: check your FXML file 'addScene.fxml'.";
        assert textPrice != null : "fx:id=\"textPrice\" was not injected: check your FXML file 'addScene.fxml'.";

    }
}
