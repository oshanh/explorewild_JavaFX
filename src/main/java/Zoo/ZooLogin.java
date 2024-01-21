package Zoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class ZooLogin extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("ZooLogin.fxml"));
        Scene scene=new Scene(loader.load());
        stage.setTitle("Login");
        Image icon=new Image("/logo.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

}
