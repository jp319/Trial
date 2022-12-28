module trailgroup.trial {
    requires javafx.controls;
    requires javafx.fxml;


    opens trailgroup.trial to javafx.fxml;
    exports trailgroup.trial;
}