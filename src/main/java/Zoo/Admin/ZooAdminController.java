package Zoo.Admin;

import Zoo.ZooLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class ZooAdminController {

    @FXML
    private AnchorPane ancMain;

    @FXML
    private Button animalBtn;

    @FXML
    private Button btnLogout;

    @FXML
    private Button empBtn;

    @FXML
    private Label lblWelcome;

    @FXML
    private Rectangle sidePanel;

    @FXML
    private Button ticketsBtn;

    @FXML
    private Button usersBtn;

    @FXML
    void AnimalTabAction(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Zoo/Admin/AnimalTab/animal.fxml"));
        Parent load=loader.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load);

        this.animalBtn.setStyle("-fx-background-color: rgba(25,220,19,0.6)");

    }

    @FXML
    void EmployeeTabAction(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Zoo/Admin/EmployeeTab/employee.fxml"));
        Parent load=loader.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load);
        this.animalBtn.setStyle("-fx-background-color: rgba(25,220,19,0.6)");
        this.animalBtn.setStyle("-fx-background-color: rgba(25,220,19,0.6)");
    }

    @FXML
    void UsersTabAction(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Zoo/Admin/UsersTab/users.fxml"));
        Parent load=loader.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load);
    }

    @FXML
    void TicketsTabAction(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Zoo/Admin/TicketTab/ticket.fxml"));
        Parent load=loader.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load);
    }

    public void setUsername(String s){
        this.lblWelcome.setText("Welcome "+s);
    }

    public void logoutBtnAction(ActionEvent actionEvent) throws IOException {

        Stage window=(Stage)ancMain.getScene().getWindow();
        window.close();


        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Zoo/ZooLogin.fxml"));

        Stage stage=new Stage();

        stage.setTitle("Login");
        Image icon=new Image("/logo.png");
        stage.getIcons().add(icon);

        stage.setScene(new Scene(loader.load()));
        stage.show();



    }


}
