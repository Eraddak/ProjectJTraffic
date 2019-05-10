package sample;

import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class Car extends Thread {

    private Double speed;
    private Point2D depart;
    private Point2D end;
    private Rectangle voiture = new Rectangle();
    private Double r;
    private Double angle;
    private Double currentDist = 0.0;
    private Rotate rotation;

    @Override
    public void run() {
        AnimationTimer timer = new AnimationTimer() {
            private long previous = 0;
            private double deltaTime = 0.0;

            @Override
            public void handle(long now) {
                now = System.currentTimeMillis();
                if(previous == 0) previous = now;
                deltaTime = (now - previous) / 1000.0; //millisecondes
                previous = now;
                deplacement(deltaTime);
            }
        };
        timer.start();

    }

    public Car(Double speed, Point2D depart, Point2D end) {
        this.speed = speed;
        this.depart = depart;
        this.end = end;


        this.r = Math.sqrt(Math.pow(this.end.getX()-this.depart.getX(), 2) + Math.pow(this.end.getY()-this.depart.getY(), 2));
        this.angle = Math.toDegrees(Math.atan2(this.end.getY() - this.depart.getY(), this.end.getX() - this.depart.getX()));
        System.out.println(angle);

        this.voiture.setX(this.depart.getX());
        this.voiture.setY(this.depart.getY());
        this.voiture.setHeight(10.0);
        this.voiture.setWidth(20.0);
        this.voiture.setStroke(Color.RED);

        this.rotation = new Rotate(this.angle, this.voiture.getX(), this.voiture.getY());

        //A TESTER // redéfini l'origine
        /*
        this.voiture.getTransforms().add(new Shear(this.voiture.getX() + this.voiture.getWidth()/2,
                this.voiture.getY() + this.voiture.getHeight()/2));
         */
        this.voiture.getTransforms().add(this.rotation);
    }

    public void deplacement(double deltaTime){
        if(this.currentDist < this.r) {
            this.voiture.setX(this.voiture.getX() + this.speed * deltaTime);
            this.currentDist += this.speed * deltaTime;
        }
    }

    public Rotate getRotation() {
        return rotation;
    }

    public void setRotation(Double newAngle) {
        this.rotation.setAngle(Math.toDegrees(newAngle));
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
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
