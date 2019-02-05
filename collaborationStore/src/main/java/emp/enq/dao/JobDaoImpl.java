package emp.enq.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import emp.enq.models.Job;
@Repository
@Transactional
public class JobDaoImpl implements JobDao {
	@Autowired
	private SessionFactory sessionFactory;
		public void addJob(Job job) {
		Session session=sessionFactory.getCurrentSession();
		session.save(job);	
		}
		public java.util.List<Job> getAlljobs(Job job) 
		{
			Session session=sessionFactory.getCurrentSession();
			Query quary=session.createQuery("from Job");
			List<Job> jobs=quary.list();
			
			return null;
		}
		public Job getJob(Job job) {
			// TODO Auto-generated method stub
			return null;
		}

	}


