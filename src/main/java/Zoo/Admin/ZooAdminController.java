package Zoo.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class ZooAdminController {

    @FXML
    private AnchorPane MainAncPain;

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


    private void animalTabLoad() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Zoo/Admin/AnimalTab/animal.fxml"));
        Parent load=loader.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load);

        this.animalBtn.setStyle("-fx-background-color: rgb(3, 166, 5);-fx-background-radius: 0;-fx-border-radius: 0;");
        this.empBtn.setStyle("-fx-background-color: #01280a;");
        this.ticketsBtn.setStyle("-fx-background-color: #01280a;");
        this.usersBtn.setStyle("-fx-background-color: #01280a;");
    }

    @FXML
    void AnimalTabAction(ActionEvent event) throws IOException {
        animalTabLoad();
    }
    @FXML
    public void animaltabload(MouseEvent mouseEvent) throws IOException {
       animalTabLoad();

    }

    private void empTabLoad() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Zoo/Admin/EmployeeTab/employee.fxml"));
        Parent load=loader.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load);
        this.animalBtn.setStyle("-fx-background-color: #01280a;");
        this.empBtn.setStyle("-fx-background-color: rgb(3, 166, 5);-fx-background-radius: 0;-fx-border-radius: 0;");
        this.ticketsBtn.setStyle("-fx-background-color: #01280a;");
        this.usersBtn.setStyle("-fx-background-color: #01280a;");
    }
    @FXML
    void EmployeeTabAction(ActionEvent event) throws IOException {
        empTabLoad();
    }

    private void userTabLoad() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Zoo/Admin/UsersTab/users.fxml"));
        Parent load=loader.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load);

        this.animalBtn.setStyle("-fx-background-color: #01280a;");
        this.empBtn.setStyle("-fx-background-color: #01280a;");
        this.usersBtn.setStyle("-fx-background-color: rgb(3, 166, 5);-fx-background-radius: 0;-fx-border-radius: 0;");
        this.ticketsBtn.setStyle("-fx-background-color: #01280a;");

    }
    @FXML
    void UsersTabAction(ActionEvent event) throws IOException {
        userTabLoad();
    }

    private void ticketsTabLoad() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Zoo/Admin/TicketTab/ticket.fxml"));
        Parent load=loader.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load);

        this.animalBtn.setStyle("-fx-background-color: #01280a;");
        this.empBtn.setStyle("-fx-background-color: #01280a;");
        this.usersBtn.setStyle("-fx-background-color: #01280a;");
        this.ticketsBtn.setStyle("-fx-background-color: rgb(3, 166, 5);-fx-background-radius: 0;-fx-border-radius: 0;");
        //this.ticketsBtn.setStyle(".sidePanelButtons:pressed");
    }
    @FXML
    void TicketsTabAction(ActionEvent event) throws IOException {
        ticketsTabLoad();
    }

    public void setUsername(String s){
        this.lblWelcome.setText("Welcome "+s);
    }

    public void logoutBtnAction(MouseEvent actionEvent) throws IOException {

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
    int c=0;

    @FXML
    private Button sidePanelMenuBtn;
    @FXML
    private AnchorPane sidePanelA;
    @FXML
    public void sidePanelHide(MouseEvent mouseEvent) throws IOException {
        c++;
        Stage window=(Stage)ancMain.getScene().getWindow();
        window.setResizable(true);

        System.out.println(c);

        if(c%2==1) {
            sidePanelA.setTranslateX(-230);
            ancMain.setPrefWidth(1388);
            ancMain.setTranslateX(-230);
            //sidePanelA.setVisible(false);





        }
        else {
            sidePanelA.setTranslateX(0);
            ancMain.setPrefWidth(1158);
            ancMain.setTranslateX(0);
            //sidePanelA.setVisible(true);


        }



    }


    public void emptabloadM(MouseEvent mouseEvent) throws IOException {
        empTabLoad();
    }

    public void userstabloadM(MouseEvent mouseEvent) throws IOException {
        userTabLoad();
    }

    public void ticketstabloadM(MouseEvent mouseEvent) throws IOException {
        ticketsTabLoad();
    }
}
