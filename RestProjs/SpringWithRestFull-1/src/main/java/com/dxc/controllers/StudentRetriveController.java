package com.dxc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.entity.Student;

import comdxc.services.StudentRegistrationService;

@RestController
public class StudentRetriveController {
	 @RequestMapping(method = RequestMethod.GET, value="/student/allstudent")
	  @ResponseBody
	  public List<Student> getAllStudents() {
	  return StudentRegistrationService.getInstance().getStudentRecords();
	  }

}
