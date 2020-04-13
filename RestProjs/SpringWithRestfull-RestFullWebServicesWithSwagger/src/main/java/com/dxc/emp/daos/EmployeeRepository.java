package com.dxc.emp.daos;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dxc.emp.bo.Employee;


@Repository("emprep")
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	public List<Employee> findAll();
	public com.dxc.emp.bo.Employee findById(int id);
	public Employee save(Employee emp);
	public void delete(Employee bo);
	

}
