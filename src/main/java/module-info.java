module com.group12.explorewild {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    


    opens com.group12.explorewild to javafx.fxml;
    exports com.group12.explorewild;
    exports Zoo;
    opens Zoo to javafx.fxml;
    exports Zoo.Admin;
    opens Zoo.Admin to javafx.fxml;
    exports Zoo.Admin.AnimalTab;
    opens Zoo.Admin.AnimalTab to javafx.fxml;
    exports Zoo.Admin.EmployeeTab;
    opens Zoo.Admin.EmployeeTab to javafx.fxml;
    exports Zoo.Admin.UsersTab;
    opens Zoo.Admin.UsersTab to javafx.fxml;
    exports Zoo.Admin.TicketTab;
    opens Zoo.Admin.TicketTab to javafx.fxml;
    exports Botany;
    opens Botany to javafx.fxml;

}