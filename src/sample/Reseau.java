package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class Reseau {

    private static Group group = new Group();
    private static ArrayList<Circle> cityTab = new ArrayList<>();
    private static ArrayList<Line> roadTab = new ArrayList<>();

    private static Reseau instance;

    public static Reseau getInstance() {
        if (null == instance) {
            instance = new Reseau();
        }
        return instance;
    }

    private Reseau(){
        // Villes
        Circle newCity1 = new Circle(200, 200,10, Color.web("0xff0000",1.0));
        Circle newCity2 = new Circle(200, 500,10, Color.web("0xff0000",1.0));
        Circle newCity3 = new Circle(600, 50,10, Color.web("0xff0000",1.0));
        Circle newCity4 = new Circle(800, 300,10, Color.web("0xff0000",1.0));
        Circle newCity5 = new Circle(550, 450,10, Color.web("0xff0000",1.0));
        Circle newCity6 = new Circle(500, 550,10, Color.web("0xff0000",1.0));
        cityTab.add(newCity1);
        cityTab.add(newCity2);
        cityTab.add(newCity3);
        cityTab.add(newCity4);
        cityTab.add(newCity5);
        cityTab.add(newCity6);

        // Routes
        for(int i=0; i<6; i++){
            Line road1 = new Line(cityTab.get(i).getCenterX(), cityTab.get(i).getCenterY(),
                    cityTab.get((i+1)%6).getCenterX(), cityTab.get((i+1)%6).getCenterY());
            road1.setStroke(Color.BLUE);
            Line road2 = new Line(cityTab.get(i).getCenterX(), cityTab.get(i).getCenterY(),
                    cityTab.get((i+2)%6).getCenterX(), cityTab.get((i+2)%6).getCenterY());
            road2.setStroke(Color.BLUE);
            roadTab.add(road1);
            roadTab.add(road2);
        }
        group.getChildren().addAll(roadTab);
        group.getChildren().addAll(cityTab);

    }

    public static Group getGroup() {
        return group;
    }

    public static ArrayList<Circle> getCityTab() {
        return cityTab;
    }

    public static ArrayList<Line> getRoadTab() {
        return roadTab;
    }
}
