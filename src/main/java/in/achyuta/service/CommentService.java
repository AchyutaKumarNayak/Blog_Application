package in.achyuta.service;

import java.util.List;

import in.achyuta.entity.Comment;
import in.achyuta.entity.Post;

public interface CommentService {
	
	List<Comment> getTopTwoCommentsByPost(Post post,Integer limit);
	void save(Comment comment);

}
