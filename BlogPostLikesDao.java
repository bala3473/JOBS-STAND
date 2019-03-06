package emp.enq.dao;

import emp.enq.models.BlogPost;
import emp.enq.models.BlogPostLikes;

public interface BlogPostLikesDao {
	//this method is used to determine the color of glyphicon thumbs up
		//if the method returns null, color of glyphicon is BLACK
		//if the method returns 1 object, color of glyphicon is BLUE
		BlogPostLikes hasUserLikedBlogPost(int blogPostId,String email);//email is loggedin user's email id
		BlogPost updateLikes(int blogPostId,String email);

}
