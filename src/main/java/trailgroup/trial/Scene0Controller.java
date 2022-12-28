package trailgroup.trial;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene0Controller {
    @FXML public Button start;
    Stage stage;
    Scene scene;
    String[] passengers = {"images/purpleTurtleNeckGirl.png",
            "images/purpleSleeveGlassesGirl.png",
            "images/greenTankTopGirl.png",
            "images/greenCoolGuy.png",
            "images/blueHoodieGuy.png"};
    public void switchToSceneOne (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene1.fxml"));
        Parent root = loader.load();
        HelloController helloController = loader.getController();
        for (int i = 0; i < passengers.length; i++) {
            helloController.setPassengers(passengers[i], i);
        }
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
