package com.niit.dao;

import java.util.List;


import com.niit.domain.BlogComment;

public interface BlogCommentDao {

	public boolean insertBlogComment(BlogComment blogComment);
	
	public List<BlogComment> list();
	
	public boolean deleteBlogComment(String id);
	
	public BlogComment getBlogCommentById(String id);
	
}
