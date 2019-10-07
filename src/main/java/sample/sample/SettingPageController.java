package sample.sample;

/**
 * Sample Skeleton for 'settingsPage.fxml' Controller Class
 */

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class SettingPageController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="buttonDeleteWorkers"
    private RadioButton buttonDeleteWorkers; // Value injected by FXMLLoader

    @FXML // fx:id="buttonEdit"
    private Button buttonEdit; // Value injected by FXMLLoader

    @FXML // fx:id="textEditId"
    private TextField textEditId; // Value injected by FXMLLoader

    @FXML // fx:id="buttonDeleteWorkOrders"
    private RadioButton buttonDeleteWorkOrders; // Value injected by FXMLLoader

    @FXML // fx:id="textNumWrkshMonth"
    private TextField textNumWrkshMonth; // Value injected by FXMLLoader

    @FXML // fx:id="buttonEditNumWrkshMonth"
    private RadioButton buttonEditNumWrkshMonth; // Value injected by FXMLLoader

    @FXML // fx:id="textDelete"
    private TextField textDelete; // Value injected by FXMLLoader

    @FXML // fx:id="textPriceAll"
    private TextField textPriceAll; // Value injected by FXMLLoader

    @FXML // fx:id="textSfpNumWrksh"
    private TextField textSfpNumWrksh; // Value injected by FXMLLoader

    @FXML // fx:id="textPrice"
    private TextField textPrice; // Value injected by FXMLLoader

    @FXML // fx:id="textMnCount"
    private TextField textMnCount; // Value injected by FXMLLoader

    @FXML // fx:id="buttonEditWorkOrders"
    private RadioButton buttonEditWorkOrders; // Value injected by FXMLLoader

    @FXML // fx:id="buttonDelete"
    private Button buttonDelete; // Value injected by FXMLLoader

    @FXML // fx:id="buttonEditPriceAll"
    private RadioButton buttonEditPriceAll; // Value injected by FXMLLoader

    @FXML // fx:id="buttonEditTechOper"
    private RadioButton buttonEditTechOper; // Value injected by FXMLLoader

    @FXML // fx:id="buttonAddWorkers"
    private RadioButton buttonAddWorkers; // Value injected by FXMLLoader

    @FXML // fx:id="textTexhOper"
    private TextField textTexhOper; // Value injected by FXMLLoader

    @FXML // fx:id="buttonEditPrice"
    private RadioButton buttonEditPrice; // Value injected by FXMLLoader

    @FXML // fx:id="labelProcess"
    private Label labelProcess; // Value injected by FXMLLoader

    @FXML // fx:id="ButtonAddWorkOrders"
    private RadioButton buttonAddWorkOrders; // Value injected by FXMLLoader

    @FXML // fx:id="buttonEditWorkers"
    private RadioButton buttonEditWorkers; // Value injected by FXMLLoader

    @FXML // fx:id="buttonAddRow"
    private Button buttonAddRow; // Value injected by FXMLLoader

    @FXML // fx:id="buttonEditSfpShiftId"
    private RadioButton buttonEditSfpShiftId; // Value injected by FXMLLoader

    @FXML // fx:id="textEdit"
    private TextField textEdit; // Value injected by FXMLLoader

    @FXML // fx:id="buttonEditMnCount"
    private RadioButton buttonEditMnCount; // Value injected by FXMLLoader

    @FXML
    void addWorkersSelected(ActionEvent event) {
        if (buttonAddWorkers.isSelected() && !buttonAddWorkOrders.isSelected()) {
            textSfpNumWrksh.setDisable(false);
            textNumWrkshMonth.setDisable(false);
            textTexhOper.setDisable(true);
            textMnCount.setDisable(true);
            textPrice.setDisable(true);
            textPriceAll.setDisable(true);
        }
        if (buttonAddWorkOrders.isSelected() && buttonAddWorkers.isSelected()) {
            textSfpNumWrksh.setDisable(true);
            textNumWrkshMonth.setDisable(true);
            textTexhOper.setDisable(true);
            textMnCount.setDisable(true);
            textPrice.setDisable(true);
            textPriceAll.setDisable(true);
        }

        if(!buttonAddWorkers.isSelected()) {
            textSfpNumWrksh.setDisable(true);
            textNumWrkshMonth.setDisable(true);
            textTexhOper.setDisable(true);
            textMnCount.setDisable(true);
            textPrice.setDisable(true);
            textPriceAll.setDisable(true);
        }
    }


    @FXML
    void addWorkOrdersSelected(ActionEvent event) {
        if (buttonAddWorkers.isSelected() && buttonAddWorkOrders.isSelected()) {
            textSfpNumWrksh.setDisable(true);
            textNumWrkshMonth.setDisable(true);
            textTexhOper.setDisable(true);
            textMnCount.setDisable(true);
            textPrice.setDisable(true);
            textPriceAll.setDisable(true);
        }
        if(buttonAddWorkOrders.isSelected() && !buttonAddWorkers.isSelected()) {
            textSfpNumWrksh.setDisable(false);
            textNumWrkshMonth.setDisable(false);
            textTexhOper.setDisable(false);
            textMnCount.setDisable(false);
            textPrice.setDisable(false);
            textPriceAll.setDisable(false);

        }
        if(!buttonAddWorkOrders.isSelected()) {
            textSfpNumWrksh.setDisable(true);
            textNumWrkshMonth.setDisable(true);
            textTexhOper.setDisable(true);
            textMnCount.setDisable(true);
            textPrice.setDisable(true);
            textPriceAll.setDisable(true);
        }
    }

    @FXML
    void addEntry(ActionEvent event) throws SQLException {
        if (buttonAddWorkers.isSelected() && !buttonAddWorkOrders.isSelected()) {

            String query = "INSERT INTO workshop.рабочие (ФИО, №_цеха) " +
                    " VALUES ('"+ textSfpNumWrksh.getText() + "' , '" + textNumWrkshMonth.getText() + "');";

            Statement stmt = null;
            stmt = DB_connect.connection.createStatement();
            stmt.executeUpdate(query);

            labelProcess.setText("Запись в таблицу 'Рабочие' добавлена");
        } else if(buttonAddWorkOrders.isSelected() && !buttonAddWorkers.isSelected()) {

            String query = "INSERT INTO workshop.наряды_рабочих (№_цеха, месяц, техОперация, количество, расценка, сумма) " +
                    " VALUES ('"+ textSfpNumWrksh.getText() + "' , '" + textNumWrkshMonth.getText() + "' , '" + textTexhOper.getText() +
                    "' , '"+ textMnCount.getText() + "' , '"+ textPrice.getText() + "' , '"+ textPriceAll.getText() + "');";

            Statement stmt = null;
            stmt = DB_connect.connection.createStatement();
            stmt.executeUpdate(query);

            labelProcess.setText("Запись в таблицу 'Наряды рабочих' добавлена");
        }
    }


    @FXML
    void editEntry(ActionEvent event) throws SQLException {
        if (buttonEditWorkers.isSelected() && !buttonEditWorkOrders.isSelected()) {
            if(buttonEditSfpShiftId.isSelected())
            {
                String query = "UPDATE рабочие SET ФИО = '" + textEdit.getText() + "' WHERE id = '" + textEditId.getText() + "';";

                Statement stmt = null;
                stmt = DB_connect.connection.createStatement();
                stmt.executeUpdate(query);

            } else if(buttonEditNumWrkshMonth.isSelected())
            {
                String query = "UPDATE рабочие SET №_цеха = '" + textEdit.getText() + "' WHERE id = '" + textEditId.getText() + "';";

                Statement stmt = null;
                stmt = DB_connect.connection.createStatement();
                stmt.executeUpdate(query);
            }
        }
        if(buttonEditWorkOrders.isSelected() && !buttonEditWorkers.isSelected()) {
            if(buttonEditSfpShiftId.isSelected())
            {
                String query = "UPDATE наряды_рабочих SET №_цеха = '" + textEdit.getText() + "' WHERE shift_id = '" + textEditId.getText() + "';";

                Statement stmt = null;
                stmt = DB_connect.connection.createStatement();
                stmt.executeUpdate(query);

            } else if(buttonEditNumWrkshMonth.isSelected())
            {
                String query = "UPDATE наряды_рабочих SET месяц = '" + textEdit.getText() + "' WHERE shift_id = '" + textEditId.getText() + "';";

                Statement stmt = null;
                stmt = DB_connect.connection.createStatement();
                stmt.executeUpdate(query);
            } else if(buttonEditTechOper.isSelected())
            {
                String query = "UPDATE наряды_рабочих SET техОперация = '" + textEdit.getText() + "' WHERE id = '" + textEditId.getText() + "';";

                Statement stmt = null;
                stmt = DB_connect.connection.createStatement();
                stmt.executeUpdate(query);
            }else if(buttonEditMnCount.isSelected())
            {
                String query = "UPDATE наряды_рабочих SET количество = '" + textEdit.getText() + "' WHERE shift_id = '" + textEditId.getText() + "';";

                Statement stmt = null;
                stmt = DB_connect.connection.createStatement();
                stmt.executeUpdate(query);
            }else if(buttonEditPrice.isSelected())
            {
                String query = "UPDATE наряды_рабочих SET расценка = '" + textEdit.getText() + "' WHERE shift_id = '" + textEditId.getText() + "';";

                Statement stmt = null;
                stmt = DB_connect.connection.createStatement();
                stmt.executeUpdate(query);
            }else if(buttonEditPriceAll.isSelected())
            {
                String query = "UPDATE наряды_рабочих SET сумма = '" + textEdit.getText() + "' WHERE shift_id = '" + textEditId.getText() + "';";

                Statement stmt = null;
                stmt = DB_connect.connection.createStatement();
                stmt.executeUpdate(query);
            }
        }
        labelProcess.setText("Запись изменена");
    }

    @FXML
    void deleteEntry(ActionEvent event) throws SQLException {
        if (buttonDeleteWorkers.isSelected() && !buttonDeleteWorkOrders.isSelected()) {
            String query = "DELETE FROM рабочие WHERE id = '" + textDelete.getText() + "';";

            Statement stmt = null;
            stmt = DB_connect.connection.createStatement();
            stmt.executeUpdate(query);

            labelProcess.setText("Запись удалена");
        } else  if (!buttonDeleteWorkers.isSelected() && buttonDeleteWorkOrders.isSelected()) {
            String query = "DELETE FROM наряды_рабочих WHERE shift_id = '" + textDelete.getText() + "';";

            Statement stmt = null;
            stmt = DB_connect.connection.createStatement();
            stmt.executeUpdate(query);

            labelProcess.setText("Запись удалена");
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert buttonDeleteWorkers != null : "fx:id=\"buttonDeleteWorkers\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert buttonEdit != null : "fx:id=\"buttonEdit\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert textEditId != null : "fx:id=\"textEditId\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert buttonDeleteWorkOrders != null : "fx:id=\"ButtonDeleteWorkOrders1\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert textNumWrkshMonth != null : "fx:id=\"textNumWrkshMonth\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert buttonEditNumWrkshMonth != null : "fx:id=\"buttonEditNumWrkshMonth\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert textDelete != null : "fx:id=\"textDelete\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert textSfpNumWrksh != null : "fx:id=\"textSfpNumWrksh\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert textPrice != null : "fx:id=\"textPrice\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert textMnCount != null : "fx:id=\"textMnCount\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert buttonEditWorkOrders != null : "fx:id=\"buttonEditWorkOrders\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert buttonDelete != null : "fx:id=\"buttonDelete\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert buttonEditPriceAll != null : "fx:id=\"buttonEditPriceAll\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert buttonEditTechOper != null : "fx:id=\"buttonEditTechOper\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert buttonAddWorkers != null : "fx:id=\"buttonAddWorkers\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert textTexhOper != null : "fx:id=\"textTexhOper\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert buttonEditPrice != null : "fx:id=\"buttonEditPrice\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert buttonAddWorkOrders != null : "fx:id=\"ButtonAddWorkOrders\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert buttonEditWorkers != null : "fx:id=\"buttonEditWorkers\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert buttonAddRow != null : "fx:id=\"buttonAddRow\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert buttonEditSfpShiftId != null : "fx:id=\"buttonEditSfpShiftId\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert textEdit != null : "fx:id=\"textEdit\" was not injected: check your FXML file 'settingsPage.fxml'.";
        assert buttonEditMnCount != null : "fx:id=\"buttonEditMnCount\" was not injected: check your FXML file 'settingsPage.fxml'.";

    }
}
