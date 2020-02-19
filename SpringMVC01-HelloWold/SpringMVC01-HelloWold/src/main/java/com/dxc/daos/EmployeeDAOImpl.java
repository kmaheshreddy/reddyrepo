package com.dxc.daos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dxc.bo.EmployeeBO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public EmployeeDAOImpl() {

	}

	public List<EmployeeBO> getDetails(int id) {
		Session s = sessionFactory.getCurrentSession();
		boolean flag = false;
		Transaction tx = null;
		List<EmployeeBO> list=null;
		EmployeeBO bo = null;
		bo = s.get(EmployeeBO.class, id);
		list=new ArrayList();
		list.add(bo);
		return list;
	}

	public int saveEmpData(EmployeeBO bo) {
		  Transaction tx=null;
		  boolean flag=false;
		  int id=0;
		  Session s=sessionFactory.getCurrentSession();
		  try {
			  tx=s.beginTransaction();
			  id=(Integer) s.save(bo);
			  flag=true;
		  }
		  catch(HibernateException he) {
			  he.printStackTrace();
			  flag=false;
		  }
		  finally {
			  if(flag) {
				  tx.commit();
			  }
			  else {
				  tx.rollback();
			  }
		  }
		return id;
	}
}
