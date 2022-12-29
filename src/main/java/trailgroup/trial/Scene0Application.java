package trailgroup.trial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene0Application extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Scene0Application.class.getResource("Scene0.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Scene0");
        stage.setScene(scene);
        stage.show();
        //Set Window/Stage in the Center of the screen
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
