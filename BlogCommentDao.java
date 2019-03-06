package emp.enq.dao;

import java.util.List;

import emp.enq.models.BlogComment;

public interface BlogCommentDao {
	void addBlogComment(BlogComment blogcomment);
	List<BlogComment> getAllBlogComments(int blogPostId);

}
