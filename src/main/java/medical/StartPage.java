package medical;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartPage implements Initializable {
    @FXML
    private AnchorPane root_1;
    AnchorPane root;

    @FXML
    private ProgressBar ProgressBar;

    public class Pg_Thread extends Thread{


        @Override
        public void run() {
            for( int i = 1;i<=100;i++) {

                ProgressBar.setProgress(i / 100.0);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
            Platform.runLater(new Runnable() {
                @Override
                public void run() {


                    try {
                   root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Stage primaryStage = new Stage();
                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
                    primaryStage.setX(primaryScreenBounds.getMinX());
                    primaryStage.setY(primaryScreenBounds.getMinY());

                    primaryStage.setMaxWidth(primaryScreenBounds.getWidth());
                    primaryStage.setMinWidth(primaryScreenBounds.getWidth());

                    primaryStage.setMaxHeight(primaryScreenBounds.getHeight());
                    primaryStage.setMinHeight(primaryScreenBounds.getHeight());
                    primaryStage.initStyle(StageStyle.TRANSPARENT);
                    primaryStage.setTitle("Assistant");
                    primaryStage.show();

                    root_1.getScene().getWindow().hide();

                }
            });






        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ProgressBar.setProgress(0.0);
        Pg_Thread pg_thread =new Pg_Thread();
        pg_thread.start();
    }

}
