package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

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
			sessionFactory.getCurrentSession().delete(id);
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

}
