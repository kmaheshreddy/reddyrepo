package com.dxc.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.emp.bo.Employee;
import com.dxc.emp.services.EmployeeService;

@RestController
public class EmployeeManageMentController {
	@Autowired
	private EmployeeService empService;
	

	@GetMapping("/display")
	public ResponseEntity<Object> getAll() {
		List<Employee> listdto = empService.fetchAllData();
		return new ResponseEntity<Object>(listdto, HttpStatus.OK);

	}

	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody Employee bo) {
		Employee emp = empService.saveData(bo);
		return new ResponseEntity<Object>("Employee is created successfully", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody Employee bo) {
		          Employee emp=empService.saveData(bo);
		return new ResponseEntity<Object>("Employee is updated successsfully", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> remove(@PathVariable("id") int id) {
            Employee emp=empService.searchById(id);
		String status = empService.removeEmp(emp);
		return new ResponseEntity<Object>(status, HttpStatus.OK);
	}
}
