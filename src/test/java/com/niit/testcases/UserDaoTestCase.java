package com.niit.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobDao;
import com.niit.dao.UserDao;
import com.niit.domain.Job;
import com.niit.domain.UserTable;

public class UserDaoTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static UserDao userDao;
	@Autowired
	static UserTable userTable;
	
	
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		// get the userDAO from context
		userDao = (UserDao) context.getBean("userDao");

		// get the user from context
		userTable = (UserTable) context.getBean("userTable");
}
	
	
	
	@Test
	public void createUserTestCase() {
	
		user.setUserId(100);
		user.setEmailId("manideeps.19@gmail.com");
		user.setFirstName("Manideep");
		user.setLastName("Panchiri");
		user.setPassword("maha");
		user.setRole("ROLE_USER");
		user.setStatus("Online");
		user.setIsOnline("S");
		
		boolean flag = userDao.insertUser(user);
		assertEquals("createUserTestCase", true, flag);
	}

}
