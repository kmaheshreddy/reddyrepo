package com.dxc.services;

import java.util.Date;

import org.springframework.stereotype.Service;
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

	public String getStatus() {
		    int time=new Date().getHours();
		   String status="";
		    if(time<=12) {
		    	status="good morning";
		    }
		    else if(time>=12) {
		    	status="good afternoon";
		    }
		    else if(time >=16) {
		    	status="good evening";
		    }
		return status;
	}

}
