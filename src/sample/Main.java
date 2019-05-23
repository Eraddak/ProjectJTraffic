package sample;

import javafx.application.Application;
import javafx.scene.Scene;
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

        running();
        Global.root.getChildren().add(Reseau.getInstance().getGroupRoad());

        for (Car i : Global.tab) {
            Global.root.getChildren().add(i.getVoiture());
        }

        //root.getChildren().add(Reseau.getInstance().getGroupCity());
        Global.root.getChildren().add(HUD.getInstance().getGroup());

        primaryStage.setScene(new Scene(Global.root, windowSizeX, windowSizeY, Color.web("0x111111", 1.0)));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
