package in.achyuta.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import in.achyuta.constants.AppConstants;
import in.achyuta.entity.Comment;
import in.achyuta.entity.Post;
import jakarta.transaction.Transactional;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
	
	List<Comment> findTopByPost(Post post,Pageable pagable);
	@Modifying
	@Transactional
	@Query(AppConstants.COMMENT_REPO_DELETE_QUERY)
	void deleteCommentById(Integer commentId);

}
