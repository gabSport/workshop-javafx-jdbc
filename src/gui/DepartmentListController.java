package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {
	
	private DepartmentService service; // dependencia com o DepartmentService
	
	@FXML
	private TableView<Department> tableViewDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML 
	private TableColumn<Department, String> tableColumnName;
	
	@FXML
	private Button btNew;
	
	private ObservableList<Department> obsList;
	             // aqui estou carregando os Department's nessa observableList.
	
	
	@FXML
	public void onBtNewAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		createDialogForm("/gui/DepartmentForm.fxml", parentStage);
	}
	
	public void SetDepartmentService(DepartmentService service) {
		this.service = service; // injecao de dependencia (aqui estou invertendo o controle) - principio 'solid'
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes(); // pra iniciar algum componente da minha tela
	}

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("Id")); // comando pra iniciar o comportamento das colunas da tabela;
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name")); 
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty()); // para fazer o tableView acompanhar a altura da Janela
	}
	
	public void updateTableView() {
		if (service == null) { // se o programador esquecer de injetar esse servico, entao lanço uma illegalStateExcepiton
			throw new IllegalStateException("Service was null");
		}
		List<Department> list = service.findAll(); // aqui recupera os departamentos la do DepartmentService (que estao MOCKADOS - 'ficticios')
		obsList = FXCollections.observableArrayList(list); // instanciei o obsList pegando os dados da list
		tableViewDepartment.setItems(obsList); // aqui carrego os itens da tableView e mostro na tela.
	}
	
	private void createDialogForm(String absolutName, Stage parentStage) { // metodo pra abrir a janela de formulario e preencher um novo Department:
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
			Pane pane = loader.load(); // carreguei minha view;
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Enter Department data:"); // para configurar o titulo da janela;
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false); // para a janela ser ou nao redimencionada
			dialogStage.initOwner(parentStage); // o stage pai dessa janela;
			dialogStage.initModality(Modality.WINDOW_MODAL); // aqui diz se a janela vai ser modal ou se terá outro comportamento;
			dialogStage.showAndWait();
		}
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view" , e.getMessage(), AlertType.ERROR);
		}
	}
}
