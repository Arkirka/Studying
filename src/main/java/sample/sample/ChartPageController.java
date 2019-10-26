package sample.sample;

/**
 * Sample Skeleton for 'ChartPage.fxml' Controller Class
 */


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChartPageController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="buttonUpdate"
    private Button buttonUpdate; // Value injected by FXMLLoader

    @FXML // fx:id="pane"
    private AnchorPane pane; // Value injected by FXMLLoader

    @FXML
    void updateChart(ActionEvent event) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Количественные показатели в таблицах");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Количества");

        BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("2014");

        dataSeries1.getData().add(new XYChart.Data<String, Number>("Java", 20.973));
        dataSeries1.getData().add(new XYChart.Data<String, Number>("C#", 4.429));
        dataSeries1.getData().add(new XYChart.Data<String, Number>("PHP", 2.792));

        barChart.getData().addAll(dataSeries1);


    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
}
