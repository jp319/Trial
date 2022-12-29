package trailgroup.trial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class Scene0Application extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Scene0Application.class.getResource("Scene0.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("buttonStyle.css")).toExternalForm());
        Scene0Controller scene0Controller = fxmlLoader.getController();
        scene0Controller.rotate();
        stage.setTitle("TRAVA AIRLINES");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.show();
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/TravaFX_Logo.png")));
        stage.getIcons().add(icon);
        //Set Window/Stage in the Center of the screen
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }
    public static void main(String[] args) {
        launch(args);
    }
}