package com.papi.dao;

import java.util.HashMap;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.papi.entity.User;
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	/*private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) 
    {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void saveUser(User user) {
		hibernateTemplate.saveOrUpdate(user);
	}

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		hibernateTemplate.find("Select * from user");
		return null;
	}*/
/*@Transactional
	   @Override
	   public Long saveUser(User user) {
	      sessionFactory.getCurrentSession().save(user);
	      return user.getId();
	   }

	  
@Transactional
	   @Override
	   public List<User> listUser() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<User> cq = cb.createQuery(User.class);
	      Root<User> root = cq.from(User.class);
	      cq.select(root);
	      Query<User> query = session.createQuery(cq);
	      return query.getResultList();
	   }
*/
	@Transactional
public void addUser(User User) {
	sessionFactory.getCurrentSession().saveOrUpdate(User);

}
	@Transactional
@SuppressWarnings("unchecked")
public List<User> getAllUsers() {

	return sessionFactory.getCurrentSession().createQuery("from User")
			.list();
}

@Transactional
@SuppressWarnings("unchecked")
public List<User> getAllUsersForGroup(Long groupId) {

	return sessionFactory.getCurrentSession().createQuery("from User where GROUP_ID="+groupId)
			.list();
}
@Transactional
@Override
public void deleteUser(Long id) {
	User User = (User) sessionFactory.getCurrentSession().load(
			User.class, id);
	if (null != User) {
		this.sessionFactory.getCurrentSession().delete(User);
	}

}
@Transactional
public User getUser(Long id) {
	return (User) sessionFactory.getCurrentSession().get(User.class,
			id);
}

@Override
public User updateUser(User User) {
	sessionFactory.getCurrentSession().update(User);
	return User;
}

}

