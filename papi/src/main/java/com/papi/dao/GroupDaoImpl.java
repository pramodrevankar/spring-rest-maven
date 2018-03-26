package com.papi.dao;

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

import com.papi.entity.Group;
@Repository
public class GroupDaoImpl implements GroupDao {
	/*private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) 
    {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void saveGroup(Group group) {
		hibernateTemplate.saveOrUpdate(group);
	}

	@Override
	public List<Group> listGroup() {
		// TODO Auto-generated method stub
		hibernateTemplate.find("Select * from group");
		return null;
	}*/
	   @Autowired
	   private SessionFactory sessionFactory;
/*@Transactional
	   @Override
	   public Long saveGroup(Group group) {
	      sessionFactory.getCurrentSession().save(group);
	      return group.getId();
	   }

	  
@Transactional
	   @Override
	   public List<Group> listGroup() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Group> cq = cb.createQuery(Group.class);
	      Root<Group> root = cq.from(Group.class);
	      cq.select(root);
	      Query<Group> query = session.createQuery(cq);
	      return query.getResultList();
	   }

@Transactional
@Override
public Group get(Long id) {
	// TODO Auto-generated method stub
	 Session session = sessionFactory.getCurrentSession();
     CriteriaBuilder cb = session.getCriteriaBuilder();
     CriteriaQuery<Group> cq = cb.createQuery(Group.class);
     Root<Group> root = cq.from(Group.class);
     cq.select(root);
     Query<Group> query = session.createQuery("Select * from Group where id="+id);
     return query.getSingleResult();
}*/
@Transactional	   
public void addGroup(Group Group) {
	sessionFactory.getCurrentSession().saveOrUpdate(Group);

}
@Transactional
@SuppressWarnings("unchecked")
public List<Group> getAllGroups() {

	return sessionFactory.getCurrentSession().createQuery("from Group")
			.list();
}
@Transactional
@Override
public void deleteGroup(Long id) {
	Group Group = (Group) sessionFactory.getCurrentSession().load(
			Group.class, id);
	if (null != Group) {
		this.sessionFactory.getCurrentSession().delete(Group);
	}

}
@Transactional
public Group getGroup(Long id) {
	return (Group) sessionFactory.getCurrentSession().get(Group.class,
			id);
}
@Transactional
@Override
public Group updateGroup(Group Group) {
	sessionFactory.getCurrentSession().update(Group);
	return Group;
}


}

