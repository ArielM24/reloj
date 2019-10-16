import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.effect.*;
import javafx.scene.text.*;
import javafx.scene.*;
import java.util.*;
import javafx.animation.*;
import java.time.*;

public class Reloj extends Parent{
	private StackPane stp;
	private Dial segundero,minutero,horero;
	private Group group;
	private Calendar calendar;
	public Reloj(){
		stp = new StackPane();
		segundero = new Dial(200,50,5,Color.CRIMSON);
		minutero = new Dial(150,40,10,Color.BLACK);
		horero = new Dial(100,30,15,Color.BLACK);
		group = new Group();
		group.getChildren().add(stp);
		group.getChildren().addAll(horero,minutero,segundero);
		getChildren().add(group);
		layoult();
	}
	private void layoult(){
		Circle contorno = new Circle(240,Color.BLACK);
		contorno.setEffect(new Lighting());
		Circle luna = new Circle(220, Color.WHITESMOKE);
		luna.setEffect(new InnerShadow());

		Text txt12 = new Text("12");
		Text txt9 = new Text("9");
		Text txt6 = new Text("6");
		Text txt3 = new Text("3");
		txt12.setTranslateY(-150);
		txt9.setTranslateX(-150);
		txt6.setTranslateY(150);
		txt3.setTranslateX(150);
		stp.getChildren().addAll(contorno,luna);
		stp.getChildren().addAll(txt12,txt9,txt6,txt3);

		Rectangle[] tickHora = new Rectangle[12];
		for(int i = 0; i < 12; i++){
			tickHora[i] = new Rectangle(20,5,Color.BLACK);
			tickHora[i].setTranslateX(190*Math.cos(-(Math.PI/6)*i));
			tickHora[i].setTranslateY(190*Math.sin(-(Math.PI/6)*i));
			tickHora[i].setRotate(-(180/6)*i);
		}
		stp.getChildren().addAll(tickHora);

		Rectangle[] tickMinuto = new Rectangle[60];
		for(int i = 0; i < 60; i++){
			if(i%5 == 0){
				continue;
			}
			tickMinuto[i] = new Rectangle(10,2,Color.BLACK);
			tickMinuto[i].setTranslateX(190*Math.cos(-(Math.PI/30)*i));
			tickMinuto[i].setTranslateY(190*Math.sin(-(Math.PI/30)*i));
			tickMinuto[i].setRotate(-(180/30)*i);
			stp.getChildren().add(tickMinuto[i]);
		}

		group.getChildren().add(new Circle(240,240,10,Color.CRIMSON));
		group.getChildren().add(new Circle(240,240,5,Color.BLACK));
		actualizar();
		ejecutar();
	}

	private void actualizar(){
		calendar = Calendar.getInstance();
		int hor = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);

		double angleS = 360 / 60 * sec,angleM = 360 / 60 * min,angleH = 360 / 12 * hor;
		segundero.actualizar(angleS);
		minutero.actualizar(angleM);
		horero.actualizar(angleH);
	}

	private void ejecutar(){
		
	}
}