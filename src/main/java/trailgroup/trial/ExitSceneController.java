package trailgroup.trial;

import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ExitSceneController implements Initializable {

    @FXML public ImageView airplane;
    @FXML public Pane headBox;
    @FXML public Label lbThankYou;
    @FXML public ImageView vim;
    @FXML public ImageView cris;
    @FXML public ImageView lorjo;
    @FXML public ImageView mars;
    @FXML public ImageView fritz;

    boolean step = false;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        plane();
        heads();
        label();
    }

    public void heads () {
        rotateHeads(fritz,7000,360);
        rotateHeads(mars,7000,360);
        rotateHeads(lorjo,7000,360);
        rotateHeads(cris,7000,360);
        rotateHeads(vim,7000,360);
        TranslateTransition airplaneFly1 = new TranslateTransition();
        airplaneFly1.setNode(headBox);
        airplaneFly1.setDuration(Duration.millis(10000));
        airplaneFly1.setCycleCount(1);
        airplaneFly1.setByX(1800);
        airplaneFly1.setByY(0);
        airplaneFly1.setInterpolator(Interpolator.LINEAR);
        airplaneFly1.play();
    }
    public void label () {
        TranslateTransition label = new TranslateTransition();
        label.setNode(lbThankYou);
        label.setDuration(Duration.millis(8500));
        label.setCycleCount(1);
        label.setByX(1511);
        label.setByY(17);
        label.setInterpolator(Interpolator.LINEAR);
        label.play();
    }
    private void rotateHeads (ImageView head, int duration, int angle) {
        RotateTransition rotateHead = new RotateTransition();
        rotateHead.setNode(head);
        rotateHead.setDuration(Duration.millis(duration));
        rotateHead.setCycleCount(TranslateTransition.INDEFINITE);
        rotateHead.setInterpolator(Interpolator.LINEAR);
        rotateHead.setByAngle(angle);
        rotateHead.play();
    }
    public void plane () {
        TranslateTransition airplaneFly1 = new TranslateTransition();
        airplaneFly1.setNode(airplane);
        airplaneFly1.setDuration(Duration.millis(2000));
        airplaneFly1.setCycleCount(1);
        airplaneFly1.setByX(399);
        airplaneFly1.setByY(-36);
        airplaneFly1.setInterpolator(Interpolator.LINEAR);
        RotateTransition airplaneRotate1 = new RotateTransition();
        airplaneRotate1.setNode(airplane);
        airplaneRotate1.setDuration(Duration.millis(2000));
        airplaneRotate1.setCycleCount(1);
        airplaneRotate1.setByAngle(-11.3);
        airplaneRotate1.setInterpolator(Interpolator.LINEAR);
        airplaneFly1.play();
        airplaneRotate1.play();
        PauseTransition pause = new PauseTransition(Duration.millis(2000));
        pause.setOnFinished(e -> {
            TranslateTransition airplaneFly2 = new TranslateTransition();
            airplaneFly2.setNode(airplane);
            airplaneFly2.setDuration(Duration.millis(2000));
            airplaneFly2.setCycleCount(1);
            airplaneFly2.setByX(343);
            airplaneFly2.setByY(-123);
            airplaneFly2.setInterpolator(Interpolator.LINEAR);
            RotateTransition airplaneRotate2 = new RotateTransition();
            airplaneRotate2.setNode(airplane);
            airplaneRotate2.setDuration(Duration.millis(2000));
            airplaneRotate2.setCycleCount(1);
            airplaneRotate2.setByAngle(-13.3);
            airplaneRotate2.setInterpolator(Interpolator.LINEAR);
            airplaneFly2.play();
            airplaneRotate2.play();
            PauseTransition pause1 = new PauseTransition(Duration.millis(2000));
            pause1.setOnFinished(even -> {
                TranslateTransition airplaneFly3 = new TranslateTransition();
                airplaneFly3.setNode(airplane);
                airplaneFly3.setDuration(Duration.millis(3000));
                airplaneFly3.setCycleCount(1);
                airplaneFly3.setByX(488);
                airplaneFly3.setByY(-404);
                airplaneFly3.setInterpolator(Interpolator.LINEAR);
                RotateTransition airplaneRotate3 = new RotateTransition();
                airplaneRotate3.setNode(airplane);
                airplaneRotate3.setDuration(Duration.millis(3000));
                airplaneRotate3.setCycleCount(1);
                airplaneRotate3.setByAngle(-4);
                airplaneRotate3.setInterpolator(Interpolator.LINEAR);
                airplaneFly3.play();
                airplaneRotate3.play();
            });
            pause1.play();
        });
        pause.play();
    }
}