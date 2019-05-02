package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javafx.util.Pair;

import javafx.scene.shape.Rectangle;

public class Car {

    private Double speed = 10.0;
    private Pair<Double,Double> start = new Pair<>(0.0, 0.0);
    private Pair<Double,Double> end = new Pair<>(10.0, 10.0);
    private Rectangle voiture = new Rectangle();

    public Car(Double speed, Pair<Double, Double> start, Pair<Double, Double> end) {
        this.speed = speed;
        this.start = start;
        this.end = end;

        voiture.setX(start.getKey());
        voiture.setY(start.getValue());
        voiture.setHeight(10.0);
        voiture.setWidth(10.0);
        voiture.setStroke(Color.GREEN);


        /*
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(translation.xProperty(), start.getKey())),
                new KeyFrame(Duration.ZERO, new KeyValue(translation.yProperty(), start.getValue())),
                new KeyFrame(new Duration(distance/speed * 1000), new KeyValue(translation.xProperty(), end.getKey())),
                new KeyFrame(new Duration(distance/speed * 1000), new KeyValue(translation.yProperty(), end.getValue()))
        );
        */
        //timeline.play();
    }

    public void update(long deltaTime){
        voiture.setTranslateX(voiture.getTranslateX() + speed * deltaTime);
        //System.out.println(voiture.getTranslateX());
        System.out.println(deltaTime);
    }

    public Rectangle getVoiture() {
        return voiture;
    }
}
