package sample.sample;
/**
 * Sample Skeleton for 'dbPage.fxml' Controller Class
 */


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class dbPageController {

    private ObservableList<Workers> workersData = FXCollections.observableArrayList();
    private ObservableList<WorkOrders> workordersData = FXCollections.observableArrayList();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // fx:id="tableWorkers"
    private TableView<Workers> tableWorkers; // Value injected by FXMLLoader

    @FXML // fx:id="tableWorkorders"
    private TableView<WorkOrders> tableWorkorders; // Value injected by FXMLLoader

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="buttonSettings"
    private Button buttonSettings; // Value injected by FXMLLoader

    @FXML // fx:id="numWrkshFir"
    private TableColumn<Workers, Integer> numWrkshFir; // Value injected by FXMLLoader

    @FXML // fx:id="priceAll"
    private TableColumn<WorkOrders, Integer> priceAll; // Value injected by FXMLLoader

    @FXML // fx:id="shiftId"
    private TableColumn<WorkOrders, Integer> shiftId; // Value injected by FXMLLoader

    @FXML // fx:id="workerId"
    private TableColumn<Workers, Integer> workerId; // Value injected by FXMLLoader

    @FXML // fx:id="numWrkshSec"
    private TableColumn<WorkOrders, Integer> numWrkshSec; // Value injected by FXMLLoader

    @FXML // fx:id="price"
    private TableColumn<WorkOrders, Integer> price; // Value injected by FXMLLoader

    @FXML // fx:id="techOper"
    private TableColumn<WorkOrders, String> techOper; // Value injected by FXMLLoader

    @FXML // fx:id="updateBut"
    private Button updateBut; // Value injected by FXMLLoader

    @FXML // fx:id="month"
    private TableColumn<WorkOrders, Integer> month; // Value injected by FXMLLoader

    @FXML // fx:id="sfp"
    private TableColumn<Workers, String> sfp; // Value injected by FXMLLoader

    @FXML // fx:id="mnCount"
    private TableColumn<WorkOrders, Integer> mnCount; // Value injected by FXMLLoader

    @FXML
    void updateDB(ActionEvent event) {
        workersData.clear();
        workordersData.clear();

        try {
            initData();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //workers columns
        workerId.setCellValueFactory(new PropertyValueFactory<Workers, Integer>("id"));
        sfp.setCellValueFactory(new PropertyValueFactory<Workers, String>("sfp"));
        numWrkshFir.setCellValueFactory(new PropertyValueFactory<Workers, Integer>("numWrksh"));

        // workorders columns
        shiftId.setCellValueFactory(new PropertyValueFactory<WorkOrders, Integer>("shiftId"));
        numWrkshSec.setCellValueFactory(new PropertyValueFactory<WorkOrders, Integer>("numWrksh"));
        month.setCellValueFactory(new PropertyValueFactory<WorkOrders, Integer>("month"));
        techOper.setCellValueFactory(new PropertyValueFactory<WorkOrders, String>("techOper"));
        mnCount.setCellValueFactory(new PropertyValueFactory<WorkOrders, Integer>("mnCount"));
        price.setCellValueFactory(new PropertyValueFactory<WorkOrders, Integer>("price"));
        priceAll.setCellValueFactory(new PropertyValueFactory<WorkOrders, Integer>("priceAll"));

        //main table magic with set into FXtables
        tableWorkers.setItems(workersData);
        tableWorkorders.setItems(workordersData);
    }

    @FXML
    void goSettingsPage(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/settingsPage.fxml"));
            Stage settingsWindow = new Stage();
            settingsWindow.setScene(new Scene(root, 600, 470));
            settingsWindow.show();
        } catch (IOException er) {
            er.printStackTrace();
        }

    }

    private void initData() throws SQLException{
        Statement st = null;
        st = DB_connect.connection.createStatement();
        ResultSet rst = st.executeQuery("SELECT * FROM рабочие;");

        while (rst.next()) {
            workersData.add(new Workers(rst.getInt(1), rst.getString(2), rst.getInt(3)));
        }

        rst = st.executeQuery("SELECT * FROM наряды_рабочих;");

        while (rst.next()) {
            workordersData.add(new WorkOrders(rst.getInt(1),rst.getInt(2),rst.getInt(3), rst.getString(4), rst.getInt(5), rst.getInt(6), rst.getInt(7)));
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert numWrkshFir != null : "fx:id=\"numWrkshFir\" was not injected: check your FXML file 'dbPage.fxml'.";
        assert priceAll != null : "fx:id=\"priceAll\" was not injected: check your FXML file 'dbPage.fxml'.";
        assert shiftId != null : "fx:id=\"shiftId\" was not injected: check your FXML file 'dbPage.fxml'.";
        assert workerId != null : "fx:id=\"workerId\" was not injected: check your FXML file 'dbPage.fxml'.";
        assert numWrkshSec != null : "fx:id=\"numWrkshSec\" was not injected: check your FXML file 'dbPage.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'dbPage.fxml'.";
        assert techOper != null : "fx:id=\"techOper\" was not injected: check your FXML file 'dbPage.fxml'.";
        assert updateBut != null : "fx:id=\"updateBut\" was not injected: check your FXML file 'dbPage.fxml'.";
        assert month != null : "fx:id=\"month\" was not injected: check your FXML file 'dbPage.fxml'.";
        assert sfp != null : "fx:id=\"spf\" was not injected: check your FXML file 'dbPage.fxml'.";
        assert mnCount != null : "fx:id=\"mnCount\" was not injected: check your FXML file 'dbPage.fxml'.";

    }
}
