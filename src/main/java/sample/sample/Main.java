package sample.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static String FX_URL = "/sample.fxml";
    public static Stage stage = null;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(getFxUrl()));
        stage = new Stage();
        stage.setTitle("Interaction with the Database");
        stage.setScene(new Scene(root, 601, 433));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Getters and Setters
     */

    public static String getFxUrl()
    {
        return FX_URL;
    }

    public static void setFxUrl(String fxUrl)
    {
        FX_URL = fxUrl;
    }
}
