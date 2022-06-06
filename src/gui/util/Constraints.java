package gui.util;

import javafx.scene.control.TextField;

public class Constraints {
	
	public static void setTextFieldInteger(TextField txt) {
		txt.textProperty().addListener((obs, oldValues, newValue) -> { // o Listener vai ser uma funcao p ser executada qd o Controller sofrer uma modificacao
			if (newValue != null && !newValue.matches("\\d*")) { // expressao regular de numero Inteiro("\\d*"): d=digito; *=qqr quantidade.
				txt.setText(oldValues);
			}
		});	
	}
	
	public static void setTextFieldMaxLength(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldValues, newValue) -> {
			if (newValue!= null && newValue.length() > max) { // para testar se o tamanho do novo valor é maior que o valor maximo;
				txt.setText(oldValues);
			}
		});
	}
	
	public static void setTextFieldDouble(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) { // expressao regular de numero com ponto flutuante
				txt.setText(oldValue);
			}
		});
	}	
}
