package Zoo.Admin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class ZooAdmin extends Application {



    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(ZooAdmin.class.getResource("ZooAdmin.fxml"));
        //Parent load=fxmlLoader.load();

        Scene scene=new Scene(fxmlLoader.load(),1434,740);

        primaryStage.setTitle("ZooAdmin");
        primaryStage.setScene(scene);
        Image icon=new Image("/logo.png");
        primaryStage.getIcons().add(icon);

        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
