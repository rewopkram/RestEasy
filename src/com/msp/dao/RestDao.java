package com.msp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.msp.model.Comment;
import com.msp.model.Person;

public class RestDao extends BaseDao {
	
	private final Logger log = Logger.getLogger(RestDao.class);

	public RestDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public Person getPerson(Long id) {
		return (Person)getById(Person.class, id);
	}
	
	public Comment getComment(Long id) {
		return (Comment)getById(Comment.class, id);
	}
	
	
	
	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public List<Person> getPersons() {
		Session session = currentSession();
		Query q = session.createQuery("select a from Access as a where a.programId = :programId and a.accessDate = :accessDate and a.studentId = :studentId");
		
//		q.setParameter("programId", programId);
//		q.setParameter("accessDate", accessDate);
//		q.setParameter("studentId", studentId);
		
		return q.list();
	}
	
	public List<Comment> getComments() {
		Session session = currentSession();
		Query q = session.createQuery("select a from Access as a where a.programId = :programId and a.accessDate >= :from and a.accessDate <= :to");
		
//		q.setParameter("programId", programId);
//		q.setParameter("from", from);
//		q.setParameter("to", to);
		
		return q.list();
	}
	
	
}
