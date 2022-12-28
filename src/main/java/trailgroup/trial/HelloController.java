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
    public ArrayList<Passengers> passengers = new ArrayList<Passengers>();//Arraylist
    public void setUpArraylist (ArrayList<Passengers> passengers) {
        this.passengers = passengers;
    }
    public void setPassengersArraylist (ArrayList<Passengers> passengers) {
        passengers.add(new Passengers(5, 5,"images/blueHoodieGuy.png"));
        passengers.add(new Passengers(4, 4,"images/greenCoolGuy.png"));
        passengers.add(new Passengers(3, 3,"images/greenTankTopGirl.png"));
        passengers.add(new Passengers(2, 2,"images/purpleSleeveGlassesGirl.png"));
        passengers.add(new Passengers(1, 1,"images/purpleTurtleNeckGirl.png"));
    }
    public void setPersonImage () {
        String imagePath1 = passengers.get(4).getImagePath();
        Image newImage1 =new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath1)));
        person1.setImage(newImage1);
        String imagePath2 = passengers.get(3).getImagePath();
        Image newImage2 =new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath2)));
        person2.setImage(newImage2);
        String imagePath3 = passengers.get(2).getImagePath();
        Image newImage3 =new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath3)));
        person3.setImage(newImage3);
        String imagePath4 = passengers.get(1).getImagePath();
        Image newImage4 =new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath4)));
        person4.setImage(newImage4);
        String imagePath5 = passengers.get(0).getImagePath();
        Image newImage5 =new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath5)));
        person5.setImage(newImage5);
    }
    int passengerToSceneTwo = 4;
    public void move (MouseEvent event) throws IOException, InterruptedException {
        Pane currentPassenger = getCurrentPane(event);
        movePassenger(event, currentPassenger, 3000, 840, 0);
    }
    public void switchToSceneTwo (MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("two_d-view.fxml"));
        Parent root = loader.load();
        TwoDView twoDView = loader.getController();
        twoDView.setCurrentPassenger(passengers.get(passengerToSceneTwo--).getImagePath());
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
            return passenger1;
        } else if (event.getSource().equals(passenger2)) {
            return passenger2;
        } else if (event.getSource().equals(passenger3)) {
            return passenger3;
        } else if (event.getSource().equals(passenger4)) {
            return passenger4;
        } else if (event.getSource().equals(passenger5)) {
            return passenger5;
        }
        return null;
    }
}