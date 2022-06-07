package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {
	
	private DepartmentService service;
	
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
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
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
		
		Stage stage = (Stage)Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty()); // para fazer o tableView acompanhar a altura da Janela
	}
	
	public void updateTableView() {
		if (service == null) { // se o programador esquecer de injetar esse servico, entao lanço uma illegalStateExcepiton
			throw new IllegalStateException("Service was null");
		}
		List<Department> list = service.findAll();
		obsList = FXCollections.observableArrayList(list); // instanciei o obsList pegando os dados da list
		tableViewDepartment.setItems(obsList); // aqui carrego os itens da tableView e mostro na tela.
	}
}
