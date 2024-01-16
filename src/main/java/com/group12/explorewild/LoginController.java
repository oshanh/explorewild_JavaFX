package com.group12.explorewild;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField pwdbox;

    @FXML
    private TextField unamebox;


    private String uname="a";
    private String pwd="z";



    @FXML
    void loginBtnAction(ActionEvent event) throws IOException {



        if(this.uname.equals(unamebox.getText()) && this.pwd.equals(pwdbox.getText())){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ZooAdmin.fxml"));
            Parent load=fxmlLoader.load();
            ZooAdminController controller= fxmlLoader.getController();
            controller.setUsername(unamebox.getText());
            Stage stage=new Stage();
            stage.setScene(new Scene(load));
            stage.show();

            Stage loginWindow=(Stage)pwdbox.getScene().getWindow();
            loginWindow.close();
        }
        else {

            System.out.println("invalid");
        }

    }

}
