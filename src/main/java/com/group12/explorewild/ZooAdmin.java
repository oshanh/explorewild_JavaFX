package com.group12.explorewild;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ZooAdmin extends Application {



    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(ZooAdmin.class.getResource("ZooAdmin.fxml"));
        //Parent load=fxmlLoader.load();

        Scene scene=new Scene(fxmlLoader.load());
        primaryStage.setTitle("ZooAdmin");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
