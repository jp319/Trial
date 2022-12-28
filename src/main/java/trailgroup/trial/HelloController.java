package trailgroup.trial;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
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

    public ArrayList<Passengers> passengers = new ArrayList<Passengers>();//Arraylist
    public void setPassengersArraylist () {
        passengers.add(new Passengers(5, 5,"images/blueHoodieGuy.png"));
        passengers.add(new Passengers(4, 4,"images/greenCoolGuy.png"));
        passengers.add(new Passengers(3, 3,"images/greenTankTopGirl.png"));
        passengers.add(new Passengers(2, 2,"images/purpleSleeveGlassesGirl.png"));
        passengers.add(new Passengers(1, 1,"images/purpleTurtleNeckGirl.png"));
    }
    public void setPersonImage () {
        String imagePath = passengers.get(4).getImagePath();
        Image newImage =new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        person1.setImage(newImage);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setPassengersArraylist();
        setPersonImage();
    }
}