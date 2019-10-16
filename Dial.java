import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.effect.*;
import javafx.scene.transform.*;

public class Dial extends Rectangle{
	private Rotate rotate;

	public Dial(double body, double tail, double width, Paint fill){
		super(width,body+tail,fill);
		rotate = new Rotate(0,240,240);
		setX(240 - width / 2);
		setY(240 - body);
		setEffect(new DropShadow());
		setArcHeight(width);
		setArcWidth(width);
		getTransforms().add(rotate);
	}

	public void actualizar(double angle){
		rotate.setAngle(angle);
	}
}