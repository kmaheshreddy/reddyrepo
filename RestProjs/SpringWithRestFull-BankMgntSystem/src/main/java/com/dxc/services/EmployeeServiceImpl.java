package com.dxc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.bo.Customer1;
import com.dxc.daos.EmployeeRepository;
import com.dxc.exceptions.beans.AccountHolderNotFound;
import com.dxc.exceptions.beans.MoneyNotDipositedError;
import com.dxc.exceptions.beans.MoneyNotWithdwanError;

@Service("service")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository emprep;

	@Override
	public Customer1 searchByAccNo(int accNo) throws AccountHolderNotFound{
		  Customer1 c1=emprep.findByAccNo(accNo);
		  if(c1==null) {
			  throw new AccountHolderNotFound("Account not found "+accNo); 
		  }
		return c1;
	}

	@Override
	public Customer1 openAccount(Customer1 c1) {
		   Customer1 cus=emprep.save(c1);
		return cus;
	}

	@Override
	public String removeCustomer(int accNo) {
	      Customer1 c1=emprep.findByAccNo(accNo);
	        String status="";
	        boolean flag=false;
	         if(flag=false) {
	        	 flag=true;
	        	 emprep.delete(c1);
	         }
	         if(flag=true) {
	        	 status="successfully removed";
	         }
		return status;
	}

	@Override
	public String depositeAmount(int amount,int accNo) throws MoneyNotDipositedError{
		   Customer1 holder=emprep.findByAccNo(accNo);
		      int amount1=(int) holder.getAmount();
		      int amount2=amount+amount1;
		      holder.setAmount(amount2);
		      emprep.save(holder);
		      String status="";
		      if(amount==(int) holder.getAmount()) {
		    	  status="money deposited successfully in "+accNo+" with"+amount+"";
		      }
		      else {
		    	  throw new MoneyNotDipositedError("money is not diposited");
		      }
		return status;
	}

	@Override
	public String withdrawAmount(int amount,int accNo) throws MoneyNotWithdwanError {
		 Customer1 holder=emprep.findByAccNo(accNo);
	      int amount1=(int) holder.getAmount();
	      int amount2=amount1-amount;
	      holder.setAmount(amount2);
	      emprep.save(holder);
	      String status="";
	      if(amount!=(int) holder.getAmount()) {
	    	  status="money withdrwan successfully from "+accNo+"  "+amount+"amount";
	      }
	      else if(amount==(int) holder.getAmount()){
	    	  throw new MoneyNotWithdwanError();
	      }
	      return status;
	}

	
	
}
