package in.achyuta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.achyuta.entity.Comment;
import in.achyuta.entity.Post;
import in.achyuta.repository.CommentRepo;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepo commentRepo;

	@Override
	public List<Comment> getTopTwoCommentsByPost(Post post, Integer limit) {
		return commentRepo.findTopByPost(post, Pageable.ofSize(limit));
	}

	@Override
	public void save(Comment comment) {
		commentRepo.save(comment);
		
	}

}
