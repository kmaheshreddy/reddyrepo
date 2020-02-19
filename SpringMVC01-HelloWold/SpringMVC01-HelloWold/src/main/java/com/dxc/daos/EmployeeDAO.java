package com.dxc.daos;

import java.util.List;

import com.dxc.bo.EmployeeBO;

public interface EmployeeDAO {
public List<EmployeeBO> getDetails(int id);
public int saveEmpData(EmployeeBO bo);
}
