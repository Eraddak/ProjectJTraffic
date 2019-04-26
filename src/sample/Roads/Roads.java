package sample.Roads;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import sample.Cities;

import java.util.ArrayList;

public class Roads {

    private static Group group = new Group();
    private static ArrayList<Line> array = new ArrayList<>();

    public static Roads getInstance() {
        if (null == instance) {
            instance = new Roads();
        }
        return instance;
    }

    private Roads() {
        Cities cities = Cities.getInstance();
        //Roads from city 0
        Line road1 = new Line(cities.getArray().get(0).getCenterX(), cities.getArray().get(0).getCenterY(),
                cities.getArray().get(1).getCenterX(), cities.getArray().get(1).getCenterY());
        road1.setStroke(Color.BLUE);
        Line road2 = new Line(cities.getArray().get(0).getCenterX(), cities.getArray().get(0).getCenterY(),
                cities.getArray().get(2).getCenterX(), cities.getArray().get(2).getCenterY());
        road2.setStroke(Color.BLUE);
        array.add(road1);
        array.add(road2);
        //Roads from city 1
        Line road3 = new Line(cities.getArray().get(1).getCenterX(), cities.getArray().get(1).getCenterY(),
                cities.getArray().get(2).getCenterX(), cities.getArray().get(2).getCenterY());
        road3.setStroke(Color.BLUE);
        Line road4 = new Line(cities.getArray().get(1).getCenterX(), cities.getArray().get(1).getCenterY(),
                cities.getArray().get(3).getCenterX(), cities.getArray().get(3).getCenterY());
        road4.setStroke(Color.BLUE);
        array.add(road3);
        array.add(road4);
        //Roads from city 2
        Line road5 = new Line(cities.getArray().get(2).getCenterX(), cities.getArray().get(2).getCenterY(),
                cities.getArray().get(3).getCenterX(), cities.getArray().get(3).getCenterY());
        road5.setStroke(Color.BLUE);
        Line road6 = new Line(cities.getArray().get(2).getCenterX(), cities.getArray().get(2).getCenterY(),
                cities.getArray().get(4).getCenterX(), cities.getArray().get(4).getCenterY());
        road6.setStroke(Color.BLUE);
        array.add(road5);
        array.add(road6);
        group.getChildren().addAll(road1, road2, road3, road4, road5, road6);
    }

    private static Roads instance;

    public Group getGroup() {
        return group;
    }

    public ArrayList<Line> getArray() {
        return array;
    }
}
