module com.group12.explorewild {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.group12.explorewild to javafx.fxml;
    exports com.group12.explorewild;
}