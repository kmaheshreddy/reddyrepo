package com.dxc.emp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.emp.bo.Employee;
import com.dxc.emp.daos.EmployeeRepository;

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
		Employee bo=emprep.findById(id);
		return bo;
	}

	@Override
	public Employee saveData(Employee bo) {
		Employee emp=emprep.save(bo);
		return emp;
	}

	public String removeEmp(Employee bo) {
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
