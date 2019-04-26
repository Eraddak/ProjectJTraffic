package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Cities {

    private static Group group = new Group();
    private static ArrayList<Circle> array = new ArrayList<>();

    public static Cities getInstance() {
        if (null == instance) {
            instance = new Cities();
        }
        return instance;
    }

    private Cities() {
            Circle newCity1 = new Circle(200, 200,10, Color.web("0xff0000",1.0));
            Circle newCity2 = new Circle(200, 500,10, Color.web("0xff0000",1.0));
            Circle newCity3 = new Circle(600, 50,10, Color.web("0xff0000",1.0));
            Circle newCity4 = new Circle(800, 300,10, Color.web("0xff0000",1.0));
            Circle newCity5 = new Circle(550, 450,10, Color.web("0xff0000",1.0));
            Circle newCity6 = new Circle(500, 550,10, Color.web("0xff0000",1.0));
            array.add(newCity1);
            array.add(newCity2);
            array.add(newCity3);
            array.add(newCity4);
            array.add(newCity5);
            array.add(newCity6);
            group.getChildren().addAll(newCity1, newCity2, newCity3, newCity4, newCity5, newCity6);
    }

    private static Cities instance;

    public Group getGroup() {
        return group;
    }

    public ArrayList<Circle> getArray() {
        return array;
    }

}
