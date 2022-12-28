package trailgroup.trial;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController {
    //Persons & Bags
    @FXML public ImageView person1;
    @FXML public ImageView bag1;
    @FXML public ImageView person2;
    @FXML public ImageView bag2;
    @FXML public ImageView person3;
    @FXML public ImageView bag3;
    @FXML public ImageView person4;
    @FXML public ImageView bag4;
    @FXML public ImageView person5;
    @FXML public ImageView bag5;
    //Passengers Pane
    @FXML public Pane passenger1;
    @FXML public Pane passenger2;
    @FXML public Pane passenger3;
    @FXML public Pane passenger4;
    @FXML public Pane passenger5;
    Stage stage;
    Scene scene;
    int passengerToSceneTwo = 0;
    String finishedPerson = "";
    String[] person = new String[5];
    int[] stats = new int[5];
    public void setPassengers(String imagePath, int passengerNumber, int stats) {
        if (passengerNumber == 0) {
            Image newImage =new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
            person1.setImage(newImage);
            person[0] = imagePath;
            this.stats[0] = stats;
            person1.setOpacity(this.stats[0]);
            bag1.setOpacity(this.stats[0]);
        } else if (passengerNumber == 1) {
            Image newImage =new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
            person2.setImage(newImage);
            person[1] = imagePath;
            this.stats[1] = stats;
            person2.setOpacity(this.stats[1]);
            bag2.setOpacity(this.stats[1]);
        }  else if (passengerNumber == 2) {
            Image newImage =new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
            person3.setImage(newImage);
            person[2] = imagePath;
            this.stats[2] = stats;
            person3.setOpacity(this.stats[2]);
            bag3.setOpacity(this.stats[2]);
        }  else if (passengerNumber == 3) {
            Image newImage =new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
            person4.setImage(newImage);
            person[3] = imagePath;
            this.stats[3] = stats;
            person4.setOpacity(this.stats[3]);
            bag4.setOpacity(this.stats[3]);
        }  else if (passengerNumber == 4) {
            Image newImage =new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
            person5.setImage(newImage);
            person[4] = imagePath;
            this.stats[4] = stats;
            person5.setOpacity(this.stats[4]);
            bag5.setOpacity(this.stats[4]);
        }
    }
    public void move (MouseEvent event) throws IOException, InterruptedException {
        Pane currentPassenger = getCurrentPane(event);
        movePassenger(event, currentPassenger, 3000, 840, 0);
    }
    public void switchToSceneTwo (MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("two_d-view.fxml"));
        Parent root = loader.load();
        TwoDView twoDView = loader.getController();
        twoDView.setCurrentPassenger(person[passengerToSceneTwo]);
        twoDView.setPersonAndStats(person, stats, finishedPerson);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void movePassenger(MouseEvent event, Pane passenger, int duration, int x, int y) {
        TranslateTransition movePassenger = new TranslateTransition();
        movePassenger.setNode(passenger);
        movePassenger.setDuration(Duration.millis(duration));
        movePassenger.setCycleCount(1);
        movePassenger.setByX(x);
        movePassenger.setByY(y);
        movePassenger.setOnFinished(e -> {
            try {
                switchToSceneTwo(event);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        movePassenger.play();
    }
    public Pane getCurrentPane (MouseEvent event) {
        if (event.getSource().equals(passenger1)) {
            passengerToSceneTwo = 0;
            finishedPerson = "person1";
            return passenger1;
        } else if (event.getSource().equals(passenger2)) {
            passengerToSceneTwo = 1;
            finishedPerson = "person2";
            return passenger2;
        } else if (event.getSource().equals(passenger3)) {
            passengerToSceneTwo = 2;
            finishedPerson = "person3";
            return passenger3;
        } else if (event.getSource().equals(passenger4)) {
            passengerToSceneTwo = 3;
            finishedPerson = "person4";
            return passenger4;
        } else if (event.getSource().equals(passenger5)) {
            passengerToSceneTwo = 4;
            finishedPerson = "person5";
            return passenger5;
        }
        return null;
    }
}