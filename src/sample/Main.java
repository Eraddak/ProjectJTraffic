package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import sample.Roads.Roads;

import java.util.ArrayList;

public class Main extends Application {

    int windowSizeX = 1000;
    int windowSizeY = 600;

    public Group groupWay(){

        Group group = new Group();

        return group;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = Cities.getInstance().getGroup();
        root.getChildren().add(Roads.getInstance().getGroup());
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, windowSizeX, windowSizeY, Color.web("0x111111",1.0)));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
