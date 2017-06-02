package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserTableDao;
import com.niit.domain.UserTable;

@Repository("userTableDao")
@Transactional
public class UserTableDaoImpl implements UserTableDao {

	@Autowired
	private SessionFactory sessionFactory;

	public UserTableDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean insertUserTable(UserTable userTable) {

		try {
			sessionFactory.getCurrentSession().saveOrUpdate(userTable);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	@Override
	public List<UserTable> list() {

		return sessionFactory.getCurrentSession().createQuery("from UserTable").list();

	}

	@Override
	public boolean deleteUserTable(int id) {
		try {
			sessionFactory.getCurrentSession().delete(getUserTableById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public UserTable getUserTableById(int id) {

		return (UserTable) sessionFactory.getCurrentSession().get(UserTable.class, id);
	}

	@Override
	public boolean validate(String emailId, String password) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("from usertable where emailId=? and password=?");
		query.setString(0, emailId);
		query.setString(1, password);
		
		if(query.uniqueResult()== null)
		{
			return false;
			//if no row exist i.e., invalid credentials
		}
		else
		{
			//if row exist i.e., valid credentials
			return true;
		}
	}

}
