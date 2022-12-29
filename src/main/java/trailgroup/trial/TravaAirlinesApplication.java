package trailgroup.trial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class TravaAirlinesApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TravaAirlinesApplication.class.getResource("main_menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("buttonStyle.css")).toExternalForm());
        MainMenuController mainMenuController = fxmlLoader.getController();
        mainMenuController.rotate();
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