package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {
	
	public static Stage currentStage(ActionEvent event) { // palco atual (currentStage) / ActionEvent � o evento que o botao recebeu.
		return (Stage) ((Node) event.getSource()).getScene().getWindow(); // o getWindow � uma SuperClass do Stage, por isso o downCasting
	}
}
