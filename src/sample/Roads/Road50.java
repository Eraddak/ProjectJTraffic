package sample.Roads;

import javafx.scene.paint.Color;
import sample.Intersection;
import sample.Ville;

public class Road50 extends Road {

    public Road50(Intersection start, Intersection end) {
        super(start, end);
        this.vitesseMax = 50d;
        this.nbVoies = 2d;
        this.line.setStroke(Color.GREEN);
        this.line.setStrokeWidth(10d);
    }

}
