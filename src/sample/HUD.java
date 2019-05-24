package sample;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

import java.awt.*;

public class HUD {
	
	private Group groupHUD = new Group();

	private static HUD instance;

	public static HUD getInstance(){
		if(instance == null)
			instance = new HUD();
		return instance;
	}

	private HUD() {
		
		final Slider traffic_slider = new Slider(1,5,50); //valeur min,valeur de depart,valeur max
		final Label traffic_label = new Label(" Densité du traffic  :");
		final Label traffic_value = new Label(Double.toString(traffic_slider.getValue()));
		traffic_value.textProperty().bind(
	            Bindings.format(
	                "%.2f",
	                traffic_slider.valueProperty()
	            )
	        );
		final Slider vitesse_slider = new Slider(-40,40,0);
		final Label vitesse_label = new Label(" Vitesse moyenne :");
		final Label vitesse_value = new Label(Double.toString(vitesse_slider.getValue()));
		vitesse_value.textProperty().bind(
	            Bindings.format(
	                "%.2f",
	                vitesse_slider.valueProperty()
	            )
	        );
		
		HBox hbox_traffic = new HBox(traffic_label,traffic_slider,traffic_value);
		HBox hbox_vitesse = new HBox(vitesse_label,vitesse_slider,vitesse_value);
		Button start = new Button(" Start ! ");
		start.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) { //action Click : Start
		        //action
		    }
		});
		VBox slider_HUD = new VBox(hbox_traffic, hbox_vitesse);
		slider_HUD.setPadding(new Insets(20, 20, 20, 20));
	    slider_HUD.setSpacing(10);
	    start.setPadding(new Insets(5,100,5,100));
		slider_HUD.getChildren().add(start);
		slider_HUD.setStyle(
	            "-fx-border-style: solid;" + 
	            "-fx-border-width: 2;" +
	            "-fx-background-color: rgba(0, 171, 244, 1);"+
	            "-fx-border-color: white;");
		slider_HUD.setAlignment(Pos.CENTER); //centre les éléments du panneau d'interface
		groupHUD.getChildren().addAll(slider_HUD);
	}
	
	public Group getGroup() {
	      return groupHUD;
	      }
}
