package com.dxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.bo.Customer1;
import com.dxc.exceptions.beans.AccountHolderNotFound;
import com.dxc.exceptions.beans.MoneyNotDipositedError;
import com.dxc.exceptions.beans.MoneyNotWithdwanError;
import com.dxc.services.EmployeeService;

@RestController
public class EmployeeManageMentController {
	@Autowired
	private EmployeeService empService;

	@GetMapping("display/{accNo}")
	public ResponseEntity<Object> displayAccHolderDetails(@PathVariable("accNo") int accNo) throws AccountHolderNotFound{
		Customer1 holder=null;	
				holder=empService.searchByAccNo(accNo);
		
		
		
		return new ResponseEntity<Object>(holder,HttpStatus.OK);
		
	}
	@PostMapping("/openaccount")
	public ResponseEntity<Object> openAccount(@RequestBody Customer1 holder){
		      Customer1 newholder=empService.openAccount(holder);
		      
		return new ResponseEntity<Object>(newholder, HttpStatus.CREATED);
		
	}
    @PutMapping("/diposite/{accNo}/{amount}")
    public ResponseEntity<Object> depositeAmount(@PathVariable("accNo")int accNo,@PathVariable("amount")int amount) throws MoneyNotDipositedError{
    	    String status="";
  
    	    	status=empService.depositeAmount(amount, accNo);
    	   
		return new ResponseEntity<Object>(status,HttpStatus.OK);
    	
    }
    @PutMapping("/withdraw/{accNo}/{amount}")
    public ResponseEntity<Object> withdrawAmount(@PathVariable("accNo")int accNo,@PathVariable("amount")int amount){
    	    String status="";
    	    try {
    	    	status=empService.withdrawAmount(amount, accNo);
    	    }
    	    catch(MoneyNotWithdwanError e) {
    	    	e.getLocalizedMessage();
    	    }
		return new ResponseEntity<Object>(status,HttpStatus.OK);
    	
    }

}
