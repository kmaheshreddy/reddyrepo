package com.dxc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dxc.dto.EmployeeDTO;
import com.dxc.services.EmployeeService;

@Controller
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
	@PostMapping("register")
	public String register(ModelMap model, HttpServletRequest req) {
		String  pcompname = req.getParameter("prscompname");
		String  deptname  =req.getParameter("");
		List<EmployeeDTO> listdto = empService.getDetailsint();
		model.addAttribute("empData", listdto);
		return "displayresult";

	}
}
