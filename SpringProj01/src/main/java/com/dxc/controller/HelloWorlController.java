package com.dxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dxc.services.HelloWorldService;
import com.dxc.services.HelloWorldServiceImpl;

@Controller
public class HelloWorlController {
	
	@Autowired
	private HelloWorldService hws=null;
	
	@RequestMapping(value="facebook",method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		hws=new HelloWorldServiceImpl();
		String status=hws.getStatus();
		model.addAttribute("status", status);
		return "loginform";
	}


	@RequestMapping(value="/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "welcome";
	}

}
