package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


public class Main extends Application {

    int windowSizeX = 1000;
    int windowSizeY = 600;

    public void running(){

        Global.tab.add(Reseau.getInstance().getCityTab().get(0).generateVoiture());

        /*for(Ville i : Reseau.getInstance().getCityTab()){
            Global.tab.add(i.generateVoiture());
        }*/
        for(Car i: Global.tab){
            i.start();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        running();
        root.getChildren().add(Reseau.getInstance().getGroupRoad());

        for (Car i : Global.tab) {
            root.getChildren().add(i.getVoiture());
        }
        //root.getChildren().add(Reseau.getInstance().getGroupCity());

        primaryStage.setScene(new Scene(root, windowSizeX, windowSizeY, Color.web("0x111111", 1.0)));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
