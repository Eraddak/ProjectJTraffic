package sample;

import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import sample.Roads.Road;
import sample.Roads.Road50;

import java.util.ArrayList;

public class Car extends Thread {

    private Double speed;
    private Point2D depart;
    private Point2D end;
    private Rectangle image = new Rectangle();
    private Double r = 0d;
    private Double angle;
    private Double currentDist = 0d;
    private Rotate rotation;
    private ArrayList<Intersection> path = new ArrayList<>();
    private Road road;
    private Road nextRoad;
    private Double way;

    @Override
    public void run() {
        AnimationTimer timer = new AnimationTimer() {
            private long previous = 0;
            private double deltaTime = 0.0;
            private Double timeSec = 0d;

            @Override
            public void handle(long now) {
                now = System.currentTimeMillis();
                if(previous == 0) previous = now;
                deltaTime = (now - previous) / 1000.0; //millisecondes
                previous = now;
                timeSec += deltaTime;

                if(timeSec >= 0.1d){
                    Double deltaSpeed = speed - nextRoad.getVitesseMax();
                    Double x = speed * deltaSpeed/5;

                    if (speed > road.getVitesseMax() || (deltaSpeed > 0 && r - currentDist < x)){
                        accelerate(-0.5d);
                        timeSec = 0d;
                    }
                    else if(speed < road.getVitesseMax()) {
                        accelerate(0.5d);
                        timeSec = 0d;
                    }
                }
                if(currentDist >= r){
                    nextDestination();
                }
                deplacement(deltaTime);
                if(path.isEmpty()) {
                    Global.root.getChildren().remove(image);
                    this.stop();
                }
            }
        };
        timer.start();
    }

    public Car(Double speed, Intersection depart, Intersection end) {

        this.image.setHeight(5d);
        this.image.setWidth(10d);
        this.image.setStroke(Color.RED);

        this.speed = speed/4;
        this.depart = depart.getPosition();
        this.end = end.getPosition();

        this.way = 1d;

        this.image.setX(this.depart.getX());
        this.image.setY(this.depart.getY());

        this.path.add(end);
        this.path.add(Reseau.getInstance().getCityTab().get(2));
        this.path.add(Reseau.getInstance().getCityTab().get(3));

        for(Road i : depart.getLinkedRoads()){
            for(Road j : this.path.get(0).getLinkedRoads()){
                if(i == j){
                    this.road = i;
                    break;
                }
            }
        }
        for(Road i : this.path.get(0).getLinkedRoads()){
            for(Road j : this.path.get(1).getLinkedRoads()){
                if(i == j){
                    this.nextRoad = i;
                    break;
                }
            }
        }

        this.r = Math.sqrt(Math.pow(this.path.get(0).getPosition().getX()-this.depart.getX(), 2) + Math.pow(this.path.get(0).getPosition().getY()-this.depart.getY(), 2));
        this.angle = Math.toDegrees(Math.atan2(this.path.get(0).getPosition().getY() - this.depart.getY(), this.path.get(0).getPosition().getX() - this.depart.getX()));
        this.rotation = new Rotate(this.angle, this.image.getX(), this.image.getY());
        this.image.getTransforms().add(this.rotation);

        this.image.setY(this.depart.getY() + this.image.getHeight());

    }

    public void deplacement(double deltaTime){

        if(this.currentDist < this.r) {
            this.image.setX(this.image.getX() + this.speed*deltaTime);
            this.currentDist += this.speed * deltaTime;
        }
    }

    public void accelerate(Double value){
        this.speed += value;
    }

    public void nextDestination(){
        if(this.path.size() > 1) {
            this.currentDist = 0d;
            this.image.setY(this.depart.getY());
            this.rotation = new Rotate(-this.angle, this.image.getX(), this.image.getY());
            this.image.getTransforms().add(this.rotation);
            this.r = Math.sqrt(Math.pow(this.path.get(1).getPosition().getX() - this.path.get(0).getPosition().getX(), 2) + Math.pow(this.path.get(1).getPosition().getY() - this.path.get(0).getPosition().getY(), 2));
            this.angle = Math.toDegrees(Math.atan2(this.path.get(1).getPosition().getY() - this.path.get(0).getPosition().getY(), this.path.get(1).getPosition().getX() - this.path.get(0).getPosition().getX()));
            this.rotation = new Rotate(this.angle, this.image.getX(), this.image.getY());
            this.image.getTransforms().add(this.rotation);
            this.image.setY(this.depart.getY() + this.way *this.image.getHeight());

            for(Road i : this.path.get(0).getLinkedRoads()){
                for(Road j : this.path.get(1).getLinkedRoads()){
                    if(i == j){
                        this.road = i;
                        break;
                    }
                }
            }
            if(this.path.size() > 2) {
                for (Road i : this.path.get(1).getLinkedRoads()) {
                    for (Road j : this.path.get(2).getLinkedRoads()) {
                        if (i == j) {
                            this.nextRoad = i;
                            break;
                        }
                    }
                }
            }
            else
                this.nextRoad = new Road50();

        }
        if(!this.path.isEmpty())
            this.path.remove(0);
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    public Rotate getRotation() {
        return rotation;
    }

    public void setRotation(Double newAngle) {
        this.rotation.setAngle(Math.toDegrees(newAngle));
    }

    public Double getSpeed() {
        return this.speed;
    }

    public Point2D getDepart() {
        return this.depart;
    }

    public Point2D getEnd() {
        return this.end;
    }

    public Rectangle getImage() {
        return this.image;
    }
}
