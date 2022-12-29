package trailgroup.trial;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;

public class TwoDView {
    @FXML public ImageView passenger;
    @FXML public ImageView bag_A;//On Scanner
    @FXML public ImageView bag_B;//Beside Passenger
    @FXML public Button startButton;//Buttons
    Stage stage;
    Scene scene;
    String finishedPerson = " ";
    String[] person = new String[5];
    int[] stats = new int[5];
    int[] isClickable = new int[5];
    public void setPersonAndStats (String[] person, int[] stats, String finishedPerson) {
        this.person = person;
        this.stats = stats;
        this.finishedPerson = finishedPerson;
    }
    public void setCurrentPassenger (String imagePath) {
        Image newImage =new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        passenger.setImage(newImage);
    }
    public ImageView getCurrentImage (MouseEvent event) {
        if (event.getSource().equals(passenger)) {
            return passenger;
        }
        return null;
    }
    public void borderHighlightOn (MouseEvent event) {
        ImageView imageView = getCurrentImage(event);
        ColorAdjust blackout = new ColorAdjust();
        blackout.setBrightness(0.1);
        imageView.setEffect(blackout);
        imageView.setCache(true);
        imageView.setCacheHint(CacheHint.SPEED);
    }
    public void borderHighlightOff (MouseEvent event) {
        ImageView imageView = getCurrentImage(event);
        imageView.setEffect(null);
        imageView.setCache(true);
        imageView.setCacheHint(CacheHint.SPEED);
    }
    public int steps = 1;
    public void move (MouseEvent event) {
        if (steps == 1) {
            step1(event, passenger);
            step1(event, bag_B);
            startButton.setDisable(true);
        }
        if (steps == 2) {
            step2(event, passenger, bag_B);//exit bag0
        }
        if (steps == 3) {
            step3(event, passenger, bag_A);//use bag4
        }
        if (steps == 4) {
            step4(event, passenger, bag_A);
        }
        if (steps == 5) {
            step5(event, passenger, bag_A);
        }
        if (steps == 6) {
            step6(event, passenger, bag_A);
        }
        steps++;
    }
    public void step1 (MouseEvent event, ImageView imageView) {
        imageView.setOpacity(1);
        fadeIn(imageView);
        movePassenger(imageView,2000,206,0);
    }
    public void step2 (MouseEvent event, ImageView passenger, ImageView bag) {
        fadeOut(bag, 1000);
        movePassenger(passenger, 2000, 151,0);
    }
    public void step3 (MouseEvent event, ImageView passenger, ImageView bag) {
        bag.setOpacity(1);
        fadeIn(bag);
        moveBag(bag, 2000, 93, 0);
    }
    public void step4(MouseEvent event, ImageView passenger, ImageView bag) {
        movePassenger(passenger, 2000,117,0);
    }
    public void step5(MouseEvent event, ImageView passenger, ImageView bag) {
        fadeOut(bag, 500);
        movePassenger(passenger, 3000, 110, 0);
        rotateBag(bag, 1500, -90);
        moveBag(bag,2000,130,9);
        fadeIn(bag);
    }
    public void step6 (MouseEvent event, ImageView passenger, ImageView bag) {
        TranslateTransition movePassenger = new TranslateTransition();
        movePassenger.setNode(passenger);
        movePassenger.setDuration(Duration.millis(2000));
        movePassenger.setCycleCount(1);
        movePassenger.setByX(231);
        movePassenger.setByY(0);
        movePassenger.play();
        TranslateTransition moveBag = new TranslateTransition();
        moveBag.setNode(bag);
        moveBag.setDuration(Duration.millis(2000));
        moveBag.setCycleCount(1);
        moveBag.setByX(231);
        moveBag.setByY(0);
        moveBag.setOnFinished(e -> {
            try {
                switchToSceneOne(event);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        moveBag.play();
    }
    public void switchToSceneOne (MouseEvent event) throws IOException {
        if (finishedPerson.equals("person5")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ExitScene.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
        } else {
            makeFinishedInvisible();
            makeFinishedUnclickable();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene1.fxml"));
            Parent root = loader.load();
            HelloController helloController = loader.getController();
            for (int i = 0; i < person.length; i++) {
                helloController.setPassengers(person[i], i, stats[i], isClickable[i]);
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
        }
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.show();
    }
    public void makeFinishedInvisible () {
        switch (finishedPerson) {
            case "person1" -> stats[0] = 0;
            case "person2" -> stats[1] = 0;
            case "person3" -> stats[2] = 0;
            case "person4" -> stats[3] = 0;
            case "person5" -> stats[4] = 0;
        }
    }
    public void makeFinishedUnclickable() { //Also set Next Passenger to Clickable
        switch (finishedPerson) {
            case "person1" -> {
                isClickable[0] = 0;
                isClickable[1] = 1;
            }
            case "person2" -> {
                isClickable[1] = 0;
                isClickable[2] = 1;
            }
            case "person3" -> {
                isClickable[2] = 0;
                isClickable[3] = 1;
            }
            case "person4" -> {
                isClickable[3] = 0;
                isClickable[4] = 1;
            }
            case "person5" -> isClickable[4] = 0;
        }
    }
    private void fadeOut(ImageView bag, int duration) {
        FadeTransition fadeOut = new FadeTransition();
        fadeOut.setNode(bag);
        fadeOut.setDuration(Duration.millis(duration));
        fadeOut.setCycleCount(1);
        fadeOut.setInterpolator(Interpolator.EASE_OUT);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.play();
    }
    private void fadeIn(ImageView bag) {
        FadeTransition fadeIn = new FadeTransition();
        fadeIn.setNode(bag);
        fadeIn.setDuration(Duration.millis(1000));
        fadeIn.setCycleCount(1);
        fadeIn.setInterpolator(Interpolator.LINEAR);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();
    }
    private void movePassenger(ImageView passenger, int duration, int x, int y) {
        TranslateTransition movePassenger = new TranslateTransition();
        movePassenger.setNode(passenger);
        movePassenger.setDuration(Duration.millis(duration));
        movePassenger.setCycleCount(1);
        movePassenger.setByX(x);
        movePassenger.setByY(y);
        movePassenger.play();
    }
    private void moveBag (ImageView bag, int duration, int x, int y) {
        TranslateTransition moveBag = new TranslateTransition();
        moveBag.setNode(bag);
        moveBag.setDuration(Duration.millis(duration));
        moveBag.setCycleCount(1);
        moveBag.setByX(x);
        moveBag.setByY(y);
        moveBag.play();
    }
    private void rotateBag (ImageView bag, int duration, int angle) {
        RotateTransition rotateBag = new RotateTransition();
        rotateBag.setNode(bag);
        rotateBag.setDuration(Duration.millis(duration));
        rotateBag.setCycleCount(1);
        rotateBag.setByAngle(angle);
        rotateBag.play();
    }
}