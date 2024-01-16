package com.group12.explorewild;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BotanyAdmin extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader=new FXMLLoader(BotanyAdmin.class.getResource("BotanyAdmin.fxml"));
        Scene scene=new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.setTitle("BotanyAdmin");
        primaryStage.show();
    }
}
