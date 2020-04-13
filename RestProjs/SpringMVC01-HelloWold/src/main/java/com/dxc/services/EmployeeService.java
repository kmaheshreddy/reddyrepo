package com.dxc.services;

import java.util.List;

import com.dxc.dto.EmployeeDTO;

public interface EmployeeService {
   public List<EmployeeDTO> getDetailsint (int id);
   public List<EmployeeDTO> getAllEmps();
   
}
