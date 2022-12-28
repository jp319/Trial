package trailgroup.trial;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.CacheHint;
import javafx.scene.control.Button;
import javafx.scene.effect.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.File;
import java.util.*;

public class TwoDView {
    @FXML public ImageView passenger;
    @FXML public ImageView bag_A;//On Scanner
    @FXML public ImageView bag_B;//Beside Passenger
    @FXML public Button startButton;//Buttons
    public String[] imagePath = {//Images Paths
            "images/blueHoodieGuy.png",
            "images/greenCoolGuy.png",
            "images/greenTankTopGirl.png",
            "images/purpleSleeveGlassesGirl.png",
            "images/purpleTurtleNeckGirl.png",
            "images/yellowHoodieGuy.png"
    };
    public ArrayList<Passengers> passengers = new ArrayList<Passengers>();//Arraylist
    public ArrayList<Bags> bags = new ArrayList<Bags>();
    public int passengerID = 0;
    public int bagID = 0;
    /*
    public void addPassenger (ActionEvent event) {
        int id = passengerID++;
        if (randomStat()) {
            passengers.add(new Passengers(id, true, 0, Integer.toString(addBag(id)), createNewPassengerImgView()));
        } else {
            passengers.add(new Passengers(id, false,0,"No Bag", createNewPassengerImgView()));
        }

    }
     */
    public int addBag (int passengerID) {
        int id = bagID++;
        bags.add(new Bags(Integer.toString(id), passengerID));
        return id;
    }
    public boolean randomStat () {
        Random random = new Random();
        int randomInt = random.nextInt(2);
        return randomInt != 0; //if randomInt != 0 return true
    }







    //JAVAFX
    /*
    public ImageView createNewPassengerImgView () {
        File folder = new File("images/passengers");
        List<File> fileList = Arrays.asList(Objects.requireNonNull(folder.listFiles()));
        Collections.shuffle(fileList);
        File file = fileList.get(0);
        ImageView imageView =  new ImageView(file.getPath());
        imageView.setFitWidth(200.0);
        imageView.setFitHeight(150.0);
        imageView.setX(41);
        imageView.setY(260);

        passenger0 =  new ImageView(file.getPath());
        passenger0.setFitWidth(200.0);
        passenger0.setFitHeight(150.0);
        passenger0.setX(41);
        passenger0.setY(260);
        return passenger0;
    }
    */



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
        moveBag.play();
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