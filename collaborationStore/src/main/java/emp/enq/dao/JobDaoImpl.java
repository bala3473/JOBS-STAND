package emp.enq.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import emp.enq.models.Job;

public class JobDaoImpl implements JobDao {
	@Autowired
	private SessionFactory sessionFactory;
		public void addJob(Job job) {
		Session session=sessionFactory.getCurrentSession();
		session.save(job);	
		}

	}


