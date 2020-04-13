package com.dxc.controller;

import java.lang.invoke.MethodType;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.bo.Employee;
import com.dxc.exceptions.beans.RecordNotFoundException;
import com.dxc.services.EmployeeService;

@RestController
@CrossOrigin(value="http://localhost:4200",maxAge = 3600)
@RequestMapping({"/api"})
public class EmployeeManageMentController {
	@Autowired
	private EmployeeService empService;

	@GetMapping
	public List<Employee> getAll() {
		List<Employee> listdto = empService.fetchAllData();
		return listdto;

	}

	@PostMapping
	public Employee register(@RequestBody Employee bo) {

		Employee emp = empService.saveData(bo);
		return emp;
	}

	@PutMapping("/{id}")
	public Employee update(@PathVariable("id")int id,@RequestBody Employee bo) {
		Employee e1=empService.searchById(id);
		e1.setId(bo.getId());
		e1.setName(bo.getName());
		e1.setCompany(bo.getCompany());
		e1.setDeptname(bo.getDeptname());
		e1.setRole(bo.getRole());
		e1.setSalary(bo.getSalary());
		System.out.println("update data"+bo.getDeptname());
		return empService.saveData(e1);
	}

	@DeleteMapping("/{id}")
	public String remove(@PathVariable("id")int id) {

		String status = empService.removeEmp(id);
		return status;
	}
	@GetMapping("/{id}")
	public Employee fetchData(@PathVariable("id")int id) {
		Employee bo=empService.searchById(id);
		   if(bo==null) {
			   throw new RecordNotFoundException("User is not available with"+id);
		   }
		return bo;
	}
}
