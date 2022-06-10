package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable {
	
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private Label labelErrorName;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	@FXML
	public void onBtSaveAction() {
		System.out.println("Saved!");
	}
	
	@FXML
	public void onBtCancelAction() {
		System.out.println("Canceled");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes(); // aqui chamo o metodo que esta implementado abaixo.
	}
	
	private void initializeNodes() { // algumas limitacoes p/ preechermos o Id e o campo Name:
		Constraints.setTextFieldInteger(txtId); // no campo Id, so vai ser aceito numero inteiro;
		Constraints.setTextFieldMaxLength(txtName, 30); // no campo Name, o max de caracteres será de 30.
	}
}
