package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

public class TestUserDAO {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	User user;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	
	public TestUserDAO()
	{
		context = new AnnotationConfigApplicationContext();
		//specify in which package you defined the classes -->scan 
		context.scan("com.niit.shoppingcart");
		context.refresh();
		//context->bean factory 
		//ask context to get the instance
		userDAO=(UserDAO)context.getBean("userDAOImpl");
	
		user=(User)context.getBean("user");
		//userDAO.list();
		/*
		user.setId("2");
		user.setMail("9");
		user.setName("abc");
		user.setPassword("efg");
		user.setRole("10");
		user.setContact("10");
		userDAO.save(user);
*/	}
	public boolean validate(String id,String pwd)
	{
		System.out.println(id + " "+pwd);
		if (userDAO.validate(id, pwd)==null)
				{
			System.out.println("user donot exist ");
			return false;
				}
		else
		{
			return true;
				}
	}
	public static void main(String[] args){
		TestUserDAO t= new TestUserDAO();
		t.validate("10","123");
}

	

}

