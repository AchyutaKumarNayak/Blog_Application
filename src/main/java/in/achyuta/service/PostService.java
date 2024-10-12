package in.achyuta.service;

import java.util.List;

import in.achyuta.binding.DashboardResponse;
import in.achyuta.entity.Post;

public interface PostService {
	
	List<Post> getIndexPage();

	List<DashboardResponse> searchPosts(Integer userId, String query);

}
