package sample;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Random;

public class Ville {

    private Circle ville;

    public Ville(Point2D position){

        this.ville = new Circle(position.getX(), position.getY(), 10, Color.web("0xff0000",1.0));

    }

    public Car generateVoiture(){

        ArrayList<Ville> cityTab = Reseau.getInstance().getCityTab();
        int arrivee = new Random().nextInt(cityTab.size());
        while (cityTab.get(arrivee).getVille() == ville){
            arrivee = new Random().nextInt(cityTab.size());
        }
        return new Car(50.0 , this.getVillePoint(), cityTab.get(arrivee).getVillePoint());
    }

    public Circle getVille() {
        return ville;
    }

    public Point2D getVillePoint(){
        return new Point2D(ville.getCenterX(), ville.getCenterY());
    }
}
