package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

@Repository("userDAOImpl")

public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public List<User> list() {
		String hql = "from user";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	@Transactional
	public User get(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);

	}
	@Transactional
	public User validate(String id, String password) {
		String hql = "from User where id='" + id + "' and password='" + password + "'";
System.out.println(hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println(query);
		//Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (User)query.uniqueResult();

	}
	@Transactional
	public boolean save(User user) {

		sessionFactory.getCurrentSession().save(user);

		return false;
	}
	@Transactional
	public boolean update(User user) {

		sessionFactory.getCurrentSession().update(user);

		return false;
	}

}
