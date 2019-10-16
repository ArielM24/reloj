import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;

public class Principal extends Application {
	private Scene scene;
	@Override
	public void start(Stage primaryStage){
		Reloj reloj = new Reloj();
		scene = new Scene(reloj);
		initComp();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void initComp(){
		try{
			scene.getStylesheets().add(
				getClass().getResource("estilo.css").toExternalForm());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch();
	}
}