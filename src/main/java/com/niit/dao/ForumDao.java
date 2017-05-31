package com.niit.dao;

import java.util.List;

import com.niit.domain.Forum;


public interface ForumDao {

	public boolean insertForum(Forum forum);
	
	public List<Forum> list();
	
	public boolean deleteForum(String id);
	
	public Forum getForumById(String id);
	
}
