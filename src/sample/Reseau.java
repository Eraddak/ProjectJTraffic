package sample;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import sample.Roads.Road;
import sample.Roads.Road80;

import java.util.ArrayList;

public class Reseau {

    private static Group groupCity = new Group();
    private static Group groupRoad = new Group();
    private static ArrayList<Ville> cityTab = new ArrayList<>();
    private static ArrayList<Road> roadTab = new ArrayList<>();

    public static Reseau getInstance() {
        if (null == instance) {
            instance = new Reseau();
        }
        return instance;
    }

    private Reseau(){
        Road80 tmp;

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
            tmp = new Road80(cityTab.get(i), cityTab.get((i+1)%6));
            cityTab.get(i).addRoad(tmp);
            cityTab.get((i+1)%6).addRoad(tmp);
            roadTab.add(tmp);
        }

        for(Road i : roadTab){
            groupRoad.getChildren().add(i.getLine());
        }
        for(Ville i: cityTab) {
            groupCity.getChildren().add(i.getVille());
        }

    }

    private static Reseau instance;

    public Group getGroupCity() {
        return groupCity;
    }

    public Group getGroupRoad() {
        return groupRoad;
    }

    public ArrayList<Ville> getCityTab() {
        return cityTab;
    }

    public ArrayList<Road> getRoadTab() {
        return roadTab;
    }
}
