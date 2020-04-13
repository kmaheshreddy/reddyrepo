package com.dxc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dxc.dto.EmployeeDTO;
import com.dxc.services.EmployeeService;

@Controller
@CrossOrigin(value="http://localhost:4200/",maxAge = 3600)
@RequestMapping({"/api"})
public class EmployeeManageMentController {
	@Autowired
	private EmployeeService empService;

	@GetMapping("home")
	public String getHome() {
		return "home";
	}

	@PostMapping("getdetails")
	public String login(ModelMap model, HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		List<EmployeeDTO> listdto = empService.getDetailsint(id);
		model.addAttribute("empData", listdto);
		return "displayresult";

	}

	/*
	 * @PostMapping("register") public String register(ModelMap model,
	 * HttpServletRequest req) { EmployeeDTO dto=null; dto=new EmployeeDTO(); int
	 * id=Integer.parseInt(req.getParameter("id")); String cname=
	 * req.getParameter("comanyname"); String deptname
	 * =req.getParameter("deptname"); String name =req.getParameter("empname");
	 * String role=req.getParameter("role"); double
	 * salary=Double.parseDouble(req.getParameter("salary")); dto.setId(id);
	 * dto.setCompany(cname); dto.setDeptname(deptname); dto.setName(name);
	 * dto.setRole(role); dto.setSalary(salary);
	 * System.out.println(dto.getCompany()); String
	 * status=empService.registerEmp(dto); model.addAttribute("txstatus", dto);
	 * return "displayresult";
	 * 
	 * }
	 */
	@GetMapping("getAllData")
	public String getAll(ModelMap model) {
		List<EmployeeDTO> listdto = empService.getAllEmps();
		model.addAttribute("empData", listdto);
		return "displayresult";

	}
	/*
	 * @GetMapping("update") public String update(ModelMap model, HttpServletRequest
	 * req) { EmployeeDTO dto=null; dto=new EmployeeDTO(); int
	 * id=Integer.parseInt(req.getParameter("id")); String cname=
	 * req.getParameter("comanyname"); String deptname
	 * =req.getParameter("deptname"); String name =req.getParameter("empname");
	 * String role=req.getParameter("role"); double
	 * salary=Double.parseDouble(req.getParameter("salary")); dto.setId(id);
	 * dto.setCompany(cname); dto.setDeptname(deptname); dto.setName(name);
	 * dto.setRole(role); dto.setSalary(salary);
	 * System.out.println(dto.getCompany()); String
	 * status=empService.registerEmp(dto); model.addAttribute("txstatus", dto);
	 * return "displayresult";
	 * 
	 * }
	 */
}
