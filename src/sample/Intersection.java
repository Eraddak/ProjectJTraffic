package sample;

import javafx.geometry.Point2D;
import sample.Roads.Road;

import java.util.ArrayList;

public class Intersection {


    private ArrayList<? super Road> linkedRoads =  new ArrayList<>();
    private Point2D position;

    public Intersection(Point2D position) {
        this.position = position;
    }

    public ArrayList<? super Road> getLinkedRoads() {
        return linkedRoads;
    }

    public void addRoad(Road newRoad){
        this.linkedRoads.add(newRoad);
    }

    public Point2D getPosition() {
        return position;
    }
}
