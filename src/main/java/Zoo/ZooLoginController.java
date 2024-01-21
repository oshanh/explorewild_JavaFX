package Zoo;


import Zoo.Admin.ZooAdminController;
import com.group12.explorewild.DbConnection_Lakshan;
import com.group12.explorewild.DBconnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ZooLoginController {

    @FXML
    private Button closeBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private PasswordField pwdTxt;

    @FXML
    private TextField unameTxt;

    private final Connection connect=DBconnection.getConnection();
    private PreparedStatement prepare;
    private ResultSet result;
    private int result2;



    public void adminLogin() {
        String sql = "SELECT * FROM admin WHERE username = ? and password = ?";


        try {
            Alert alert;

            if (unameTxt.getText().isEmpty() || pwdTxt.getText().isEmpty()) {

                //validating empty
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, unameTxt.getText());
                prepare.setString(2, pwdTxt.getText());

                result = prepare.executeQuery();

                if (result.next()) {

                    //then proceed to the dashbord
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");

                    alert.setHeaderText(null);
                    alert.setContentText("Login successfull!");
                    alert.showAndWait();

                    //hide the login form
                    loginBtn.getScene().getWindow().hide();

                    //link dashBord form
                    Parent root = FXMLLoader.load(getClass().getResource("/Zoo/Admin/ZooAdmin.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("Zoo Management System - Admin");
                    Image icon=new Image("/logo.png");
                    stage.getIcons().add(icon);
                    stage.show();

                } else {
                    //error msg show
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong username or password");
                    alert.showAndWait();
                }

            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        System.exit(0);
    }


}
