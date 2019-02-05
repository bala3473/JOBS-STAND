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
		public List<Job> getAlljobs(Job job) 
		{
			Session session=sessionFactory.getCurrentSession();
			Query quary=session.createQuery("from Job");
			List<Job> jobs=quary.list();
			System.out.println("get all-jobs"+jobs);
			return jobs;
		}
		public Job getJob(int jobId) {
			Session session=sessionFactory.getCurrentSession();
			Job job=(Job)session.get(Job.class,jobId);
			System.out.println("job details"+job);
			return job;
		}
		public void update(Job job) {
			Session session=sessionFactory.getCurrentSession();
			session.update(job);
			
		}

	}


