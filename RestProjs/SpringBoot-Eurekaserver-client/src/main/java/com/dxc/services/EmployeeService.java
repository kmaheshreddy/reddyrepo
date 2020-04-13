package com.dxc.services;

import java.util.List;

import com.dxc.bo.Employee;

public interface EmployeeService {
  public List<Employee>  fetchAllData();
  public Employee searchById(int id);
  public Employee saveData(Employee bo);
  public String removeEmp(int id );
}
