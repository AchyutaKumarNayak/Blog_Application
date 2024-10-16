package in.achyuta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.achyuta.binding.DashboardResponse;
import in.achyuta.constants.AppConstants;
import in.achyuta.entity.Post;
import in.achyuta.service.PostService;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	@Autowired
	private HttpSession session;
	
	
	
	
	
	@Autowired
	private PostService postService;
	
	 @GetMapping("/")
	    public String getIndexPage(Model model) {
	        List<Post> posts = postService.getIndexPage();
	        model.addAttribute(AppConstants.POSTS, posts);
	        System.out.println(posts);
	        return AppConstants.INDEX;
	    }
	 @GetMapping("/filter")
	 @ResponseBody
	 public List<DashboardResponse> searchPosts(@RequestParam(AppConstants.SEARCH_QUERY) String query) {
	     Integer userId = (Integer) session.getAttribute(AppConstants.SESSION_USER_ID);
	     return postService.searchPosts(userId, query);
	 }
	 
}
