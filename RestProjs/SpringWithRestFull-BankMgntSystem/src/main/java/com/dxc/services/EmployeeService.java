package com.dxc.services;

import com.dxc.bo.Customer1;
import com.dxc.exceptions.beans.AccountHolderNotFound;
import com.dxc.exceptions.beans.MoneyNotDipositedError;
import com.dxc.exceptions.beans.MoneyNotWithdwanError;

public interface EmployeeService {
  public Customer1 searchByAccNo(int accNo) throws AccountHolderNotFound;
  public Customer1 openAccount(Customer1 c1);
  public String removeCustomer(int accNo);
  public String depositeAmount(int amount,int accNo) throws MoneyNotDipositedError;
  public String withdrawAmount(int amount,int accNo) throws MoneyNotWithdwanError;
}
