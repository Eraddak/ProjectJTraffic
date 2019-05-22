package sample;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Random;

public class Ville extends Intersection {

    private Circle ville;

    public Ville(Point2D position){

        super(position);
        this.ville = new Circle(position.getX(), position.getY(), 10, Color.web("BLUE",1.0));
        this.ville.setRadius(40d);

    }

    public Car generateVoiture(){

        //Random
        /*
        ArrayList<Ville> cityTab = Reseau.getInstance().getCityTab();
        int arrivee = new Random().nextInt(cityTab.size());
        while (cityTab.get(arrivee).getVille() == ville) {
            arrivee = new Random().nextInt(cityTab.size());
        }
        */

        return new Car(100.0 , this, Reseau.getInstance().getCityTab().get(1));
    }

    public Circle getVille() {
        return ville;
    }

}
