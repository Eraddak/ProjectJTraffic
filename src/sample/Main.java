package sample;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Main extends Application {

    int windowSizeX = 1000;
    int windowSizeY = 600;

    ArrayList<Car> tab = new ArrayList<>();

    public void running(){
        for(int i=0; i<20; i++){
            tab.add(new Car(Math.random()*100 + 30, new Point2D(Math.random() * 800, Math.random() * 500), new Point2D(Math.random() * 800,Math.random() * 500)));
        }
        for (Car i : tab){
            i.start();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        running();
        root.getChildren().add(Reseau.getInstance().getGroup());
        for(Car i : tab){
            root.getChildren().add(i.getVoiture());
        }
        primaryStage.setScene(new Scene(root, windowSizeX, windowSizeY, Color.web("0x111111",1.0)));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
