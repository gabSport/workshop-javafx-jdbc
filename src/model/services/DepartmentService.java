package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService { // Servico relacionado a operacoes com o Department
// tenho que declarar uma dependencia desse servico la no controlador do DepartmentList, para carregar os elementos inseridos e mostrar na tela TableView
	
	private DepartmentDao dao = DaoFactory.createDepartmentDao();
	
	public List<Department> findAll() {
		return dao.findAll(); // isso vai la no banco de dados e busca todos o departamentos.
	}
}
