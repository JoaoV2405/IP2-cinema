module com.example.cineurubufinal {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                            
    opens com.example.cineurubufinal to javafx.fxml;
    exports com.example.cineurubufinal;
}