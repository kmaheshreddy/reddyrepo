package com.dxc.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.bo.EmployeeBO;
import com.dxc.daos.EmployeeDAO;
import com.dxc.dto.EmployeeDTO;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO dao;

	@Transactional
	public List<EmployeeDTO> getDetailsint(int id) {
		List<EmployeeBO> listbo = dao.getDetails(id);
		
		List<EmployeeDTO> listdto= new ArrayList();
		for (EmployeeBO bo : listbo) {
			EmployeeDTO dto = new EmployeeDTO();
            BeanUtils.copyProperties(bo, dto);
			listdto.add(dto);
		}
		return listdto;
	}

	/*
	 * @Transactional public String registerEmp(EmployeeDTO dto) { EmployeeBO
	 * bo=null; String status=""; bo=new EmployeeBO(); BeanUtils.copyProperties(dto,
	 * bo); int id=dao.saveEmpData(bo); System.out.println(bo.getId()); if(id!=0) {
	 * status="Employee Registered Successfully"; } else {
	 * status="Employee Not Registered Successfully"; } return status; }
	 */
    @Transactional
	public List<EmployeeDTO> getAllEmps() {
	      List<EmployeeBO> listbo=dao.getAllEmpDetails();
	      List<EmployeeDTO> listdto=new ArrayList<EmployeeDTO>();
	       for(EmployeeBO bo:listbo) {
	    	   EmployeeDTO dto=new EmployeeDTO();
	    	   BeanUtils.copyProperties(bo, dto);
	    	   listdto.add(dto);
	       }
		return listdto;
	}

}
