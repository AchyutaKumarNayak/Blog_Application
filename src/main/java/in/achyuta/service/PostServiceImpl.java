package in.achyuta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.achyuta.binding.DashboardResponse;
import in.achyuta.entity.Post;
import in.achyuta.entity.User;
import in.achyuta.repository.PostRepo;
import in.achyuta.repository.UserRepo;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public List<Post> getIndexPage() {
		return postRepo.findAll();
	}



	@Override
	public List<DashboardResponse> searchPosts(Integer userId, String query) {
	    List<DashboardResponse> dashboardResponses = new ArrayList<>();
	    
	    List<Post> posts;
	    if (userId != null) {
	        // Fetch posts for the logged-in user
	        Optional<User> byId = userRepo.findById(userId);
	        if (byId.isPresent()) {
	            posts = byId.get().getPosts();
	        } else {
	            posts = new ArrayList<>();
	        }
	    } else {
	        // Fetch posts for all users
	        posts = postRepo.findAll();
	    }
	    
	    // Filter posts based on the query (title or description)
	    for (Post post : posts) {
	        if (post.getTitle().toLowerCase().contains(query.toLowerCase()) || 
	            post.getDescription().toLowerCase().contains(query.toLowerCase())) {
	            DashboardResponse response = new DashboardResponse();
	            response.setPostId(post.getPostId());
	            response.setTitle(post.getTitle());
	            response.setDescription(post.getDescription());
	            response.setCreatedOn(post.getCreatedOn());
	            dashboardResponses.add(response);
	        }
	    }

	    return dashboardResponses;
	}



	@Override
	public Post getPostByPostId(Integer postId) {
		
		Optional<Post> byId = postRepo.findById(postId);
		if (byId.isPresent()) {
			Post post = byId.get();
			return post;
		}
		
		return null;
	}
	


}
