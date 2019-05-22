package sample;

import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import sample.Roads.Road;

import java.util.ArrayList;

public class Car extends Thread {

    private Double speed;
    private Point2D depart;
    private Point2D end;
    private Rectangle voiture = new Rectangle();
    private Double r = 0d;
    private Double angle;
    private Double currentDist = 0d;
    private Rotate rotation;
    private ArrayList<Intersection> parcours = new ArrayList<>();
    private Road road;

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
                /*if(speed < //road && timeSec >= 0.2d) {
                    accelerate(-1d);
                    timeSec = 0d;
                }*/
                if(currentDist >= r){
                    nextDestination();
                }
                deplacement(deltaTime);
                if(parcours.isEmpty()) {

                    this.stop();
                }
            }
        };
        timer.start();
    }

    public Car(Double speed, Intersection depart, Intersection end) {

        this.voiture.setHeight(5d);
        this.voiture.setWidth(10d);
        this.voiture.setStroke(Color.RED);

        this.speed = speed;
        this.depart = depart.getPosition();
        this.end = end.getPosition();

        this.voiture.setX(this.depart.getX());
        this.voiture.setY(this.depart.getY());

        this.parcours.add(end);
        this.parcours.add(Reseau.getInstance().getCityTab().get(2));
        this.parcours.add(Reseau.getInstance().getCityTab().get(3));

        this.r = Math.sqrt(Math.pow(this.parcours.get(0).getPosition().getX()-this.depart.getX(), 2) + Math.pow(this.parcours.get(0).getPosition().getY()-this.depart.getY(), 2));
        this.angle = Math.toDegrees(Math.atan2(this.parcours.get(0).getPosition().getY() - this.depart.getY(), this.parcours.get(0).getPosition().getX() - this.depart.getX()));
        this.rotation = new Rotate(this.angle, this.voiture.getX(), this.voiture.getY());
        this.voiture.getTransforms().add(this.rotation);

    }

    public void deplacement(double deltaTime){

        if(this.currentDist < this.r) {
            this.voiture.setX(this.voiture.getX() + this.speed*deltaTime);
            this.currentDist += this.speed * deltaTime;
        }
    }

    public void accelerate(Double value){
        this.speed += value;
    }

    public void nextDestination(){
        if(this.parcours.size() > 1) {
            this.currentDist = 0d;
            this.rotation = new Rotate(-this.angle, this.voiture.getX(), this.voiture.getY());
            this.voiture.getTransforms().add(this.rotation);
            this.r = Math.sqrt(Math.pow(this.parcours.get(1).getPosition().getX() - this.parcours.get(0).getPosition().getX(), 2) + Math.pow(this.parcours.get(1).getPosition().getY() - this.parcours.get(0).getPosition().getY(), 2));
            this.angle = Math.toDegrees(Math.atan2(this.parcours.get(1).getPosition().getY() - this.parcours.get(0).getPosition().getY(), this.parcours.get(1).getPosition().getX() - this.parcours.get(0).getPosition().getX()));
            this.rotation = new Rotate(this.angle, this.voiture.getX(), this.voiture.getY());
            this.voiture.getTransforms().add(this.rotation);
        }
        if(!this.parcours.isEmpty())
            this.parcours.remove(0);
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

    public Rectangle getVoiture() {
        return this.voiture;
    }
}
