package sample;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class Reseau {

    private static Group group = new Group();
    private static ArrayList<Ville> cityTab = new ArrayList<>();
    private static ArrayList<Line> roadTab = new ArrayList<>();

    public static Reseau getInstance() {
        if (null == instance) {
            instance = new Reseau();
        }
        return instance;
    }

    private Reseau(){
        // Villes
        Ville newCity1 = new Ville(new Point2D(200, 200));
        Ville newCity2 = new Ville(new Point2D(200, 500));
        Ville newCity3 = new Ville(new Point2D(600, 50));
        Ville newCity4 = new Ville(new Point2D(800, 300));
        Ville newCity5 = new Ville(new Point2D(550, 450));
        Ville newCity6 = new Ville(new Point2D(500, 550));
        cityTab.add(newCity1);
        cityTab.add(newCity2);
        cityTab.add(newCity3);
        cityTab.add(newCity4);
        cityTab.add(newCity5);
        cityTab.add(newCity6);

        // Routes
        for(int i=0; i<6; i++){
            Line road1 = new Line(cityTab.get(i).getVille().getCenterX(), cityTab.get(i).getVille().getCenterY(),
                    cityTab.get((i+1)%6).getVille().getCenterX(), cityTab.get((i+1)%6).getVille().getCenterY());
            road1.setStroke(Color.BLUE);
            Line road2 = new Line(cityTab.get(i).getVille().getCenterX(), cityTab.get(i).getVille().getCenterY(),
                    cityTab.get((i+2)%6).getVille().getCenterX(), cityTab.get((i+2)%6).getVille().getCenterY());
            road2.setStroke(Color.BLUE);
            roadTab.add(road1);
            roadTab.add(road2);
        }
        group.getChildren().addAll(roadTab);
        for(Ville i: cityTab) {
            group.getChildren().add(i.getVille());
        }

    }

    private static Reseau instance;

    public Group getGroup() {
        return group;
    }

    public ArrayList<Ville> getCityTab() {
        return cityTab;
    }

    public ArrayList<Line> getRoadTab() {
        return roadTab;
    }
}
