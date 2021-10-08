module com.example.cs180_10_04 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cs180_10_04 to javafx.fxml;
    exports com.example.cs180_10_04;
}