module com.example.ca {
    requires javafx.controls;
    requires javafx.fxml;


    opens CA to javafx.fxml;
    exports CA;
}