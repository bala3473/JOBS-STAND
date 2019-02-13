package emp.enq.dao;

import java.util.List;

import emp.enq.models.Job;

public interface JobDao {

	public void addJob(Job job);

	public List<Job> getAlljobs(Job job);

	public Job getJob(int jobId);

	public void update(Job job);
	void delete(int jobId);

}
