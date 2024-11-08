package in.achyuta.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.achyuta.binding.AddPostForm;
import in.achyuta.binding.DashboardResponse;
import in.achyuta.constants.AppConstants;
import in.achyuta.entity.Post;
import in.achyuta.entity.User;
import in.achyuta.repository.PostRepo;
import in.achyuta.repository.UserRepo;
import jakarta.servlet.http.HttpSession;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private HttpSession sesion;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PostRepo postRepo;
	

	@Override
	public boolean addPost(AddPostForm form) {
		
		Post post= new Post();
		BeanUtils.copyProperties(form, post);
		Integer userId=(Integer)sesion.getAttribute(AppConstants.SESSION_USER_ID);
		 Optional<User> byId = userRepo.findById(userId);
		 if(byId.isPresent()) {
			 User user = byId.get();
			 post.setUser(user);
			 postRepo.save(post);
			 return true;
		 }
		
		return false;
	}

	@Override
	public List<DashboardResponse> getDashboardRes(Integer userId) {
	    // Fetch the user by ID from the repository
	    Optional<User> byId = userRepo.findById(userId);

	    // Initialize an empty list to store DashboardResponse objects
	    List<DashboardResponse> dashboardResponses = new ArrayList<>();

	    // Check if the user is present
	    if (byId.isPresent()) {
	        User user = byId.get();
	        List<Post> posts = user.getPosts(); // Get the list of posts for the user

	        // Iterate through the list of posts and create DashboardResponse objects
	        for (Post post : posts) {
	            DashboardResponse response = new DashboardResponse();

	            // Set the fields for DashboardResponse using data from the Post
	            response.setPostId(post.getPostId());
	            response.setTitle(post.getTitle());
	            response.setDescription(post.getDescription());
	            response.setCreatedOn(post.getCreatedOn());

	            // Add the DashboardResponse to the list
	            dashboardResponses.add(response);
	        }
	    }

	    // Return the list of DashboardResponse objects
	    return dashboardResponses;
	}

	@Override
	public Post getPostById(Integer postId) {
		Optional<Post> byId = postRepo.findById(postId);
		if (byId.isPresent()) {
			Post post = byId.get();
			return post;
		}
		
		return null;
	}

	@Override
	public AddPostForm editPost(Integer postId) {
		AddPostForm form= new AddPostForm();
		Optional<Post> byId = postRepo.findById(postId);
		if (byId.isPresent()) {
			Post post = byId.get();
			form.setPostId(post.getPostId());
			form.setTitle(post.getTitle());
			form.setDescription(post.getDescription());
			form.setContent(post.getContent());
			return form;
		}
		return null;
	}
	
	@Override
	public boolean updatePost(AddPostForm form) {
		Optional<Post> byId = postRepo.findById(form.getPostId());
		if (byId.isPresent()) {
			Post existingPost = byId.get();
			existingPost.setTitle(form.getTitle());
			existingPost.setDescription(form.getDescription());
			existingPost.setContent(form.getContent());
			postRepo.save(existingPost);
			return true;
		}
		return false;
	}
	@Override
	public boolean deletePost(Integer postId) {
		Optional<Post> byId = postRepo.findById(postId);
		if(byId.isPresent()) {
			postRepo.deletePostById(postId);
			return true;
		}
		return false;
	}
	@Override
	public List<DashboardResponse> searchPosts(Integer userId,String query) {
		 Optional<User> byId = userRepo.findById(userId);
		List<DashboardResponse> dashboardRespones=new ArrayList<>();
		if(byId.isPresent()) {
			User user = byId.get();
			List<Post> posts = user.getPosts();
		
		  for(Post post:posts) {
			if(post.getTitle().toLowerCase().contains(query.toLowerCase())) {
				DashboardResponse response=new DashboardResponse();
				response.setPostId(post.getPostId());
				response.setTitle(post.getTitle());
				response.setCreatedOn(post.getCreatedOn());
				response.setDescription(post.getDescription());
				dashboardRespones.add(response);
			}
			
		  }
		}
        return dashboardRespones;
    }

	

	

}
