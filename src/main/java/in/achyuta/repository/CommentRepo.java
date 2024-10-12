package in.achyuta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.achyuta.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
