package in.achyuta.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import in.achyuta.entity.Comment;
import in.achyuta.entity.Post;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
	
	List<Comment> findTopByPost(Post post,Pageable pagable);

}
