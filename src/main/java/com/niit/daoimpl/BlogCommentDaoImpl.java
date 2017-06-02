package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.BlogCommentDao;
import com.niit.domain.BlogComment;
@Repository("blogCommentDao")
@Transactional
public class BlogCommentDaoImpl implements BlogCommentDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public BlogCommentDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public boolean insertBlogComment(BlogComment blogComment) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(blogComment);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
		return true;
	}

	@Override
	public List<BlogComment> list() {
		return sessionFactory.getCurrentSession().createQuery("from BlogComment").list();
		
	}

	@Override
	public boolean deleteBlogComment(int id) {
		try{
			sessionFactory.getCurrentSession().delete(getBlogCommentById(id));
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public BlogComment getBlogCommentById(int id) {
		return (BlogComment) sessionFactory.getCurrentSession().get(BlogComment.class, id);
	}

}
