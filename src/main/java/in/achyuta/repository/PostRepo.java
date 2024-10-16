package in.achyuta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import in.achyuta.constants.AppConstants;
import in.achyuta.entity.Post;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	    @Modifying
	    @Transactional
	    @Query(AppConstants.POST_REPO_DELETE_QUERY)
	    void deletePostById(Integer postId);
	    // Finds posts by title or description containing the search term (case-insensitive)
	    List<Post> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String titleKeyword, String descriptionKeyword);
	

}
