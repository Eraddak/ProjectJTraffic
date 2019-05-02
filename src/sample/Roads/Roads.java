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

        for(int i=0; i<6; i++){
            Line road1 = new Line(cities.getArray().get(i).getCenterX(), cities.getArray().get(i).getCenterY(),
                    cities.getArray().get((i+1)%6).getCenterX(), cities.getArray().get((i+1)%6).getCenterY());
            road1.setStroke(Color.BLUE);
            Line road2 = new Line(cities.getArray().get(i).getCenterX(), cities.getArray().get(i).getCenterY(),
                    cities.getArray().get((i+2)%6).getCenterX(), cities.getArray().get((i+2)%6).getCenterY());
            road2.setStroke(Color.BLUE);
            array.add(road1);
            array.add(road2);
        }
        group.getChildren().addAll(array);
    }

    private static Roads instance;

    public Group getGroup() {
        return group;
    }

    public ArrayList<Line> getArray() {
        return array;
    }
}
