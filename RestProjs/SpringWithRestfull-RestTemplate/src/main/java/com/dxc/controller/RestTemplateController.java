package com.dxc.controller;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxc.bo.Employee;

@RestController
public class RestTemplateController {
	@Autowired
	private RestTemplate template;
	@GetMapping("getAllData")
	public ResponseEntity<String> FetchData() {
		 //GETMAPPING
	      HttpHeaders headers=new HttpHeaders();
	      headers.setAccept(Collections.singletonList(org.springframework.http.MediaType.APPLICATION_JSON));
		  HttpEntity<String> entity=new HttpEntity<String>(headers);
		  return template.exchange("http://localhost:4141/getAllData", HttpMethod.GET, entity, String.class);
	}
	@PostMapping("register")
	public ResponseEntity<String> register(@RequestBody Employee bo) {
		  HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Employee> entity = new HttpEntity<Employee>(bo,headers);
	      return template.exchange("http://localhost:4141/register", HttpMethod.POST, entity, String.class);
	}
       
}
