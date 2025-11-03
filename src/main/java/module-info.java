module com.cgvsu.rasterizationapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.cgvsu.rasterizationfxapp to javafx.fxml;
    exports com.cgvsu.rasterizationfxapp;
    exports com.cgvsu.rasterization;
}