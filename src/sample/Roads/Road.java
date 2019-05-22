package sample.Roads;

import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import javafx.util.Pair;
import sample.Intersection;
import sample.Ville;

public abstract class Road {

    private Intersection start;
    private Intersection end;
    protected Line line;
    protected Double vitesseMax;
    protected Double nbVoies;
    protected Pair<Intersection, Intersection> villes;

    public Road(Intersection start, Intersection end) {
        this.start = start;
        this.end = end;
        this.villes = new Pair<>(start, end);
        this.line = new Line(this.start.getPosition().getX(), this.start.getPosition().getY(), this.end.getPosition().getX(), this.end.getPosition().getY());
    }

    public Double getVitesseMax() {
        return vitesseMax;
    }
    public Intersection getStart() {
        return start;
    }
    public Intersection getEnd() {
        return end;
    }
    public Line getLine() {
        return line;
    }
    public Double getDistance(){
        return Math.sqrt(Math.pow(this.end.getPosition().getX()-this.start.getPosition().getX(), 2) + Math.pow(this.end.getPosition().getY()-this.start.getPosition().getY(), 2));
    }

}
