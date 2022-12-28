package trailgroup.trial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainTwoDApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainTwoDApplication.class.getResource("two_d-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Baggage Scanner");
        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.show();
    }
}
