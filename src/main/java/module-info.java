module com.example.ca {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens CA to javafx.fxml;
    exports CA;
}