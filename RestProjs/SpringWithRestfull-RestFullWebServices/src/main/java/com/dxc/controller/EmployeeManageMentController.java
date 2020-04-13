package com.dxc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.bo.Employee;
import com.dxc.services.EmployeeService;

@RestController
public class EmployeeManageMentController {
	@Autowired
	private EmployeeService empService;
	
	@GetMapping(value ="home")
	public String goToHome() {
		return "home";

	}

	@GetMapping(value = "getAllData")
	public ResponseEntity<Object> getAll() {
		List<Employee> listdto = empService.fetchAllData();
		return new ResponseEntity<Object>(listdto, HttpStatus.OK);

	}

	@PostMapping("register")
	public ResponseEntity<Object> register(@RequestBody Employee bo) {
		Employee emp = empService.saveData(bo);
		return new ResponseEntity<Object>("Employee is created successfully", HttpStatus.CREATED);
	}

	@PutMapping("update")
	public ResponseEntity<Object> update(@RequestBody Employee bo) {
		          Employee emp=empService.saveData(bo);
		return new ResponseEntity<Object>("Employee is updated successsfully", HttpStatus.OK);
	}

	@DeleteMapping("delete")
	public ResponseEntity<Object> remove(@RequestBody Employee bo) {

		String status = empService.removeEmp(bo);
		return new ResponseEntity<Object>(status, HttpStatus.OK);
	}
}
