package trailgroup.trial;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainMenuController {
    @FXML public Button start;
    @FXML public ImageView trava1;
    Stage stage;
    Scene scene;
    String[] passengers = {
            "images/purpleTurtleNeckGirl.png",
            "images/purpleSleeveGlassesGirl.png",
            "images/greenTankTopGirl.png",
            "images/greenCoolGuy.png",
            "images/blueHoodieGuy.png"
    };
    int[] stats = {
            1,
            1,
            1,
            1,
            1
    };
    int[] isClickable = {
            1,
            0,
            0,
            0,
            0
    };
    public void rotate () {
        RotateTransition rotation = new RotateTransition();
        rotation.setNode(trava1);
        rotation.setDuration(Duration.millis(5000));
        rotation.setCycleCount(TranslateTransition.INDEFINITE);
        rotation.setInterpolator(Interpolator.LINEAR);
        rotation.setByAngle(-360);
        rotation.play();
    }
    public void switchToSceneOne (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene_one-view.fxml"));
        Parent root = loader.load();
        SceneOneController sceneOneController = loader.getController();
        for (int i = 0; i < passengers.length; i++) {
            sceneOneController.setPassengers(passengers[i], i, stats[i], isClickable[i]);
        }
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.show();
    }


}
