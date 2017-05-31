package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.ForumCommentDao;

import com.niit.domain.ForumComment;

@Repository("forumCommentDao")
@Transactional
public class ForumCommentDaoImpl implements ForumCommentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ForumCommentDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean insertForumComment(ForumComment forumComment) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(forumComment);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<ForumComment> list() {
		return sessionFactory.getCurrentSession().createQuery("from ForumComment").list();
	}

	@Override
	public boolean deleteForumComment(String id) {
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
	public ForumComment getForumCommentById(String id) {
		return (ForumComment) sessionFactory.getCurrentSession().get(ForumComment.class, id);
		
	}

	
}
