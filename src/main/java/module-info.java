module com.example.kbc {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.kbc to javafx.fxml;
    exports com.example.kbc;
}