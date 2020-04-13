package com.dxc.bo;



import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

@Entity
@Table(name="Employee")
public class Employee implements Serializable{

	@Id
	@Type(type="int")
	@Column(length =10)
	private int id;
	@Column(length =25)
	@Type(type="string")
	private String name;
	@Column(length =25)
	@Type(type="string")
	private String deptname;
	@Column(length =25)
	@Type(type="string")
	private String company;
	@Column(length =25)
	@Type(type="string")
	private String role;
	@Column(length =10)
	@Type(type="double")
	private double salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
