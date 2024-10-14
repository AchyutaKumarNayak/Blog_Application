package in.achyuta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.achyuta.binding.ToShowComments;
import in.achyuta.entity.Comment;
import in.achyuta.entity.Post;
import in.achyuta.entity.User;
import in.achyuta.repository.CommentRepo;
import in.achyuta.repository.UserRepo;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public List<Comment> getTopTwoCommentsByPost(Post post, Integer limit) {
		return commentRepo.findTopByPost(post, Pageable.ofSize(limit));
	}

	@Override
	public void save(Comment comment) {
		commentRepo.save(comment);
		
	}

	@Override
	public List<ToShowComments> toShowComments(Integer userId) {
		Optional<User> byId = userRepo.findById(userId);
		List<ToShowComments> toShowComments=new ArrayList<>();
		if(byId.isPresent()) {
			User user = byId.get();
			List<Post> userPosts = user.getPosts();
			for(Post posts:userPosts) {
				for(Comment comment:posts.getComments()) {
					ToShowComments comments=new ToShowComments();
					comments.setPostId(posts.getPostId());
					comments.setCommentId(comment.getCommentId());
					comments.setCommentContent(comment.getCommentContent());
					comments.setCommentorEmail(comment.getCommentorEmail());
					comments.setTitle(posts.getTitle());
					comments.setCreatedOn(comment.getCreatedOn());
					toShowComments.add(comments);
				}
			}
		}
		return toShowComments;
	}

}
