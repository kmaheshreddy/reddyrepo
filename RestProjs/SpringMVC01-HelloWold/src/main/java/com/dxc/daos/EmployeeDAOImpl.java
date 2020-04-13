package com.dxc.daos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.query.Query;
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
		List<EmployeeBO> list = null;
		EmployeeBO bo = null;
		bo = s.get(EmployeeBO.class, id);
		list = new ArrayList();
		list.add(bo);
		return list;
	}
	public List<EmployeeBO> getAllEmpDetails() {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cbuilder = s.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<EmployeeBO> cquery = cbuilder.createQuery(EmployeeBO.class);
		Root<EmployeeBO> root = cquery.from(EmployeeBO.class);
		cquery.select(root);
		Query<EmployeeBO> queryr = s.createQuery(cquery);
		List<EmployeeBO> listbo = queryr.getResultList();
		return listbo;
	}
}
