package com.dxc.daos;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dxc.bo.Customer1;


@Repository("emprep")
public interface EmployeeRepository extends CrudRepository<Customer1, Long> {
	

	public com.dxc.bo.Customer1 findByAccNo(int accNo);
	public Customer1 save(Customer1 c1);
	public void delete(Customer1 c1);
	

}
