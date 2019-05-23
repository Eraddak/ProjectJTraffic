package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


public class Main extends Application {

    int windowSizeX = 1000;
    int windowSizeY = 600;

    public void generate(Integer nb){
        for(int i =0; i< nb; i++) {
            for (Ville v : Reseau.getInstance().getCityTab()) {
                Global.tab.add(v.generateVoiture());
            }
        }
    }

    public void running(){

        for(Car i: Global.tab){
            i.start();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        generate(5);
        running();
        Global.root.getChildren().add(Reseau.getInstance().getGroupRoad());

        for (Car i : Global.tab) {
            Global.root.getChildren().add(i.getImage());
        }

        Global.root.getChildren().add(Reseau.getInstance().getGroupCity());
        Global.root.getChildren().add(HUD.getInstance().getGroup());

        primaryStage.setScene(new Scene(Global.root, windowSizeX, windowSizeY, Color.web("0x111111", 1.0)));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
