package sample.Roads;

import javafx.scene.paint.Color;
import sample.Intersection;
import sample.Ville;

public class Road130 extends Road {

    public Road130(Intersection start, Intersection end) {
        super(start, end);
        this.vitesseMax = 130d;
        this.nbVoies = 6d;
        this.line.setStroke(Color.RED);
        this.line.setStrokeWidth(60d);
    }
}
