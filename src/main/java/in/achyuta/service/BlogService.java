package in.achyuta.service;

import java.util.List;

import in.achyuta.binding.AddPostForm;
import in.achyuta.binding.DashboardResponse;
import in.achyuta.entity.Post;
import jakarta.transaction.Transactional;

public interface BlogService {
	
	public List<DashboardResponse> getDashboardRes(Integer userId);
	
	public boolean addPost(AddPostForm form);
	
	public Post getPostById(Integer postId);
	
	public AddPostForm editPost(Integer postId);
	
	@Transactional
	public boolean deletePost(Integer postId);
	
	public boolean updatePost(AddPostForm form);

	List<DashboardResponse> searchPosts(Integer userId,String query);
	
    		

}
