package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDao;
import com.niit.domain.User;


@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public boolean insertUser(User user) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;	
	}

	@Override
	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
		
	}

	@Override
	public boolean deleteUser(String id) {
		try{
			sessionFactory.getCurrentSession().delete(id);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;	
	}

	@Override
	public User getUserById(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
		
	}

}
