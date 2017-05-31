package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.FriendDao;
import com.niit.domain.Friend;

@Repository("friendDao")
@Transactional
public class FriendDaoImpl implements FriendDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public FriendDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean insertFriend(Friend friend) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(friend);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Friend> list() {
		return sessionFactory.getCurrentSession().createQuery("from Friend").list();
	}

	@Override
	public boolean deleteFriend(String id) {
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
	public Friend getFriendById(String id) {
	return (Friend) sessionFactory.getCurrentSession().get(Friend.class, id);
	}

}
