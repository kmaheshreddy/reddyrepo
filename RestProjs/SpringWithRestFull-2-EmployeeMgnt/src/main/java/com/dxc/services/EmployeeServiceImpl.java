package com.dxc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.bo.Employee;
import com.dxc.daos.EmployeeRepository;

@Service("service")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository emprep;

	@Override
	public List<Employee> fetchAllData() {

		List<Employee> list = new ArrayList();
		list = emprep.findAll();
		return list;
	}

	@Override
	public Employee searchById(int id) {
		
		return emprep.findById(id);
	}

	@Override
	public Employee saveData(Employee bo) {
		Employee emp=emprep.save(bo);
		return emp;
	}

	public String removeEmp(int id) {
		Employee bo=searchById(id);
		 emprep.delete(bo);
		 String status="";
		 if(bo!=null) {
			 status="removed successfully";
		 }
		 else {
			  status=" Not removed successfully";
		 }
		 return status;
	}
	
}
