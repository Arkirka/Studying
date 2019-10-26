package sample.sample;
/**
 * Sample Skeleton for 'dbPage.fxml' Controller Class
 */


import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pdfbox.pdmodel.PDDocument;

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

    @FXML // fx:id="buttonChart"
    private Button buttonChart; // Value injected by FXMLLoader

    @FXML // fx:id="buttonPrintReport"
    private Button buttonPrintReport; // Value injected by FXMLLoader

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

    @FXML // fx:id="buttonReport"
    private Button buttonReport; // Value injected by FXMLLoader

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
    void goSettingsPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/dbSettingsPage.fxml"));
        Stage settingsPage = new Stage();
        settingsPage.setScene(new Scene(root, 699, 588));
        settingsPage.show();
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

    @FXML
    void toChartPage(ActionEvent event) throws IOException {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Показатели");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Количества");

        // Create a BarChart
        BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);

        XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<String, Number>();

        dataSeries1.getData().add(new XYChart.Data<String, Number>("Рабочие", 20.973));
        dataSeries1.getData().add(new XYChart.Data<String, Number>("Смены", 4.429));
        dataSeries1.getData().add(new XYChart.Data<String, Number>("Цеха", 2.792));

        barChart.getData().add(dataSeries1);

        VBox vbox = new VBox(barChart);
        Stage settingsPage = new Stage();
        settingsPage.setScene(new Scene(vbox, 400, 400));
        settingsPage.show();
    }

    @FXML
    void createReport(ActionEvent event) throws DocumentException, IOException, SQLException {
        Statement st = null;
        st = DB_connect.connection.createStatement();
        ResultSet rst = st.executeQuery("SELECT * FROM рабочие;");
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Report.pdf"));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        document.open();
        //подключаем файл шрифта, который поддерживает кириллицу
        BaseFont bf = BaseFont.createFont("C:\\Windows\\Fonts\\ARIAL.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        // tuning font
        Font headFont = new Font(bf, 16);
        Font font = new Font(bf, 14);
        // work with text in pdf
        //do report for first report
        Paragraph title1 = new Paragraph("Рабочие", headFont);
        Chapter chapter1 = new Chapter(title1, 1);

        chapter1.setNumberDepth(0);

        Paragraph title11 = new Paragraph("Отчёт для таблицы 'Рабочие'", font);

        Section section1 = chapter1.addSection(title11);
        //work with table
        PdfPTable t = new PdfPTable(3);
        t.setSpacingBefore(25);
        t.setSpacingAfter(25);
        PdfPCell cW1 = new PdfPCell(new Phrase("ID", font));
        t.addCell(cW1);
        PdfPCell cW2 = new PdfPCell(new Phrase("ФИО",font));
        t.addCell(cW2);
        PdfPCell cW3 = new PdfPCell(new Phrase("№ цеха",font));
        t.addCell(cW3);
        while (rst.next()) {
            t.addCell(rst.getString(1));
            PdfPCell cTable1 = new PdfPCell(new Phrase(rst.getString(2), font));
            t.addCell(cTable1);
            t.addCell(rst.getString(3));
        }
        section1.add(t);
        document.add(chapter1);
        //do report for second page
        document.newPage();

        rst = st.executeQuery("SELECT * FROM наряды_рабочих;");

        Paragraph title2 = new Paragraph("Наряды рабочих", headFont);
        Chapter chapter2 = new Chapter(title2, 2);

        chapter2.setNumberDepth(0);

        Paragraph title12 = new Paragraph("Отчёт для таблицы 'Наряды рабочих'", font);

        Section section2 = chapter2.addSection(title12);
        //work with table
        PdfPTable t1 = new PdfPTable(7);
        t1.setSpacingBefore(25);
        t1.setSpacingAfter(25);
        PdfPCell cWO1 = new PdfPCell(new Phrase("SHIFT ID", font));
        t1.addCell(cWO1);
        PdfPCell cWO2 = new PdfPCell(new Phrase("№ цеха",font));
        t1.addCell(cWO2);
        PdfPCell cWO3 = new PdfPCell(new Phrase("месяц",font));
        t1.addCell(cWO3);
        PdfPCell cWO4 = new PdfPCell(new Phrase("тех.Операция",font));
        t1.addCell(cWO4);
        PdfPCell cWO5 = new PdfPCell(new Phrase("Количество",font));
        t1.addCell(cWO5);
        PdfPCell cWO6 = new PdfPCell(new Phrase("Расценка",font));
        t1.addCell(cWO6);
        PdfPCell cWO7 = new PdfPCell(new Phrase("Сумма",font));
        t1.addCell(cWO7);
        while (rst.next()) {
            t1.addCell(rst.getString(1));
            t1.addCell(rst.getString(2));
            t1.addCell(rst.getString(3));
            PdfPCell cTable1 = new PdfPCell(new Phrase(rst.getString(4), font));
            t1.addCell(cTable1);
            t1.addCell(rst.getString(5));
            t1.addCell(rst.getString(6));
            t1.addCell(rst.getString(7));
        }
        section2.add(t1);
        document.add(chapter2);


        document.close();
    }

    @FXML
    void printReport(ActionEvent event) throws IOException, PrinterException, SQLException, DocumentException {
        createReport(event);
        PDDocument doc = PDDocument.load("Report.pdf");
        doc.print();
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
