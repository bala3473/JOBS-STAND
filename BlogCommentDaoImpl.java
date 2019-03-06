package emp.enq.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import emp.enq.models.BlogComment;

public class BlogCommentDaoImpl implements BlogCommentDao{
private SessionFactory sessionFactory;
	public void addBlogComment(BlogComment blogcomment) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(blogcomment);
	}

	public List<BlogComment> getAllBlogComments(int blogPostId) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogComment where blogPost.blogPostId=?");
		query.setInteger(0, blogPostId);
		@SuppressWarnings("unchecked")
		List<BlogComment> blogComments=query.list();
		return blogComments;
	}

	
}
