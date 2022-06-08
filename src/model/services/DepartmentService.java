package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;

public class DepartmentService { // Servico relacionado a operacoes com o Department
// tenho que declarar uma dependencia desse servico la no controlador do DepartmentList, para carregar os elementos inseridos e mostrar na tela TableView
	
	public List<Department> findAll() {
		List<Department> list = new ArrayList<>();
		list.add(new Department(1, "Books"));
		list.add(new Department(2, "Computers"));
		list.add(new Department(3, "Electronics"));
		return list;
	}
}
