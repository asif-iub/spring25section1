module com.iub.oop.spring25section1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.iub.oop.spring25section1 to javafx.fxml;
    exports com.iub.oop.spring25section1;
}