package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Pair;
import javafx.animation.AnimationTimer;

public class Main extends Application {

    int windowSizeX = 1000;
    int windowSizeY = 600;

    Car voitureTest = new Car(2000.0, new Pair<>(50.0,50.0), new Pair<>(500.0,400.0));

    public Group groupWay(){

        Group group = new Group();

        return group;
    }

    public void update(long deltaTime){
        voitureTest.update(deltaTime);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        AnimationTimer timer = new AnimationTimer() {
            private long previous = 0;
            long deltaTime = 0;

            @Override
            public void handle(long now) {
                if(previous == 0) previous = now;
                deltaTime = (now - previous) / 1000000000; //millisecondes
                previous = now;
                update(deltaTime);
            }
        };
        timer.start();

        Group root = new Group();
        root.getChildren().add(voitureTest.getVoiture());
        primaryStage.setScene(new Scene(root, windowSizeX, windowSizeY, Color.web("0x111111",1.0)));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
