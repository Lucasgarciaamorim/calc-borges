module com.borges.calculadoraborges2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.borges.calculadoraborges2 to javafx.fxml;
    exports com.borges.calculadoraborges2;
}