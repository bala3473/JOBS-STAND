package emp.enq.Controllers;

	import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

	import emp.enq.dao.JobDao;
	import emp.enq.models.ErrorClazz;
	import emp.enq.models.Job;
	@RestController
	public class JobController {

		@Autowired
		private JobDao jobDao;
		public Job job;
		//T is Type of data that will be added in the body of HttpResponse
		//if Job details gets inserted successfully  - T is Job object
		//if there is an exception while inserting job details  - T is ErrorClazz object
		//client has to add the data in the body of the Http Request
		//handler method has to read the data from the body of the request
	@RequestMapping(value="/addjob",method=RequestMethod.POST)
	public ResponseEntity<?> addjob(@RequestBody Job job){
	try {
		job.setPostedOn(new Date());
		jobDao.addJob(job);
	}
	catch(Exception e) {
		ErrorClazz errorClazz=new ErrorClazz(1, "job deytails are not inserted succesfully"+e.getMessage());
		return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<Job>(job,HttpStatus.OK);

	    //success - Job,200 OK
		//exception - ErrorClazz,500 ISE
		//So we need 2 ResponseEntity Objects
		//in controller , in callback function, response.data -> ErrorClazz / job
		//function for success - response.data is Job , response.status - 200 OK
		//function for error - response.data is ErrorClazz , response.status - 500	
	}
	@RequestMapping(value="/getAlljobs",method=RequestMethod.GET)
	public ResponseEntity<?> getAlljobs()
	{
		List<Job> jobs=jobDao.getAlljobs(job); 
		if(jobs.isEmpty())
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		else
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
		
	}
	@RequestMapping( value="/getJob", method=RequestMethod.GET)
	public ResponseEntity<?> getJob(@RequestParam int jobId)
	{
		Job job=jobDao.getJob(jobId);
		if(job==null)
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<Job>(HttpStatus.OK);
	}
	{
	
	

	}
	}
	



