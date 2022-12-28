package trailgroup.trial;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Scene0Controller {
    public Button start;
    Stage stage;
    Scene scene;
    public ArrayList<Passengers> passengers = new ArrayList<Passengers>();//Arraylist
    public void switchToSceneOne (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene0.fxml"));
        Parent root = loader.load();
        passengers();
        HelloController helloController = new HelloController();
        helloController.setUpArraylist(passengers);
        helloController.setPassengersArraylist(passengers);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void passengers() {
        passengers.add(new Passengers(5, 5,"images/blueHoodieGuy.png"));
        passengers.add(new Passengers(4, 4,"images/greenCoolGuy.png"));
        passengers.add(new Passengers(3, 3,"images/greenTankTopGirl.png"));
        passengers.add(new Passengers(2, 2,"images/purpleSleeveGlassesGirl.png"));
        passengers.add(new Passengers(1, 1,"images/purpleTurtleNeckGirl.png"));
    }
}
