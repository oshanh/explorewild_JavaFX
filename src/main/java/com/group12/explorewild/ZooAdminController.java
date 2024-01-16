package com.group12.explorewild;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ZooAdminController {

    @FXML
    private AnchorPane ancMain;

    @FXML
    private Label lblWelcome;

    @FXML
    void btn1OnAction(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("form1.fxml"));
        Parent load=loader.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load);

    }

    @FXML
    void btn2OnAction(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("form2.fxml"));
        Parent load=loader.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load);
    }

    @FXML
    void btn3OnAction(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("form3.fxml"));
        Parent load=loader.load();

        ancMain.getChildren().clear();
        ancMain.getChildren().add(load);
    }

    @FXML
    void btn4OnAction(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("form4.fxml"));
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

        FXMLLoader loader=new FXMLLoader(getClass().getResource("Login.fxml"));

        Stage stage=new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.show();



    }
}
