package sample.Roads;

import javafx.scene.paint.Color;
import sample.Intersection;
import sample.Ville;

public class Road80 extends Road {

    public Road80(Intersection start, Intersection end) {
        super(start, end);
        this.vitesseMax = 80d;
        this.nbVoies = 4d;
        this.line.setStroke(Color.YELLOW);
        this.line.setStrokeWidth(20d);
    }


}
