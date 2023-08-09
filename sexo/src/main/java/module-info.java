module com.example.sexo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sexo to javafx.fxml;
    exports com.example.sexo;
}