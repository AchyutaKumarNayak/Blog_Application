package in.achyuta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.achyuta.binding.AddPostForm;
import in.achyuta.binding.DashboardResponse;
import in.achyuta.binding.ToShowComments;
import in.achyuta.constants.AppConstants;
import in.achyuta.service.BlogService;
import in.achyuta.service.CommentService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BlogController {
	
	@Autowired
	private HttpSession session;
	@Autowired
	private BlogService blogService;
	@Autowired 
	private CommentService commentService;

	
	
	
	@GetMapping("/logout")
    public String logout() {
		session.invalidate();
    	return AppConstants.INDEX;
    }
	
	@GetMapping("/dashboard")
	public String getDashboard(Model model) {
		Integer userId =(Integer)session.getAttribute(AppConstants.SESSION_USER_ID);
		List<DashboardResponse> dashboardRes = blogService.getDashboardRes(userId);
		model.addAttribute(AppConstants.POSTS, dashboardRes);
		return AppConstants.DASHBOARD;
	}
	@GetMapping("/addPost")
	public String addPost(Model model) {
		model.addAttribute(AppConstants.ADD_POST,new AddPostForm());
		return AppConstants.ADD_POST;
	}
	@PostMapping("/addPost")
	public String handleAddPost(@ModelAttribute(AppConstants.ADD_POST) AddPostForm form,Model model) {
		System.out.println(form);
		boolean status = blogService.addPost(form);
		if(status) {
			model.addAttribute(AppConstants.SUCC_MSG_KEY, AppConstants.SUCC_MSG_VALUE_ADD);
		}else {
			model.addAttribute(AppConstants.ERR_MSG_KEY, AppConstants.ERR_MSG_VALUE_ADD);
		}
		return "redirect:/dashboard";
	}
	@GetMapping("/editPost/{id}")
	public String editPost(@PathVariable Integer id, Model model) {
	    AddPostForm form = blogService.editPost(id);
	    System.out.println(form);
	    model.addAttribute(AppConstants.ADD_POST, form);
	    return AppConstants.EDIT_POST; 
	}
	@PostMapping("/updatePost")
	public String updatePost(@ModelAttribute(AppConstants.ADD_POST) AddPostForm form, Model model) {
	    blogService.updatePost(form);
	    return "redirect:/dashboard";
	}
	@GetMapping("/deletePost/{id}")
    public String deletePost(@PathVariable Integer id,Model model) {
		boolean status = blogService.deletePost(id);
		if (status) {
	        model.addAttribute(AppConstants.SUCC_MSG_KEY, AppConstants.SUCC_MSG_VALUE_DELETE);
	    } else {
	        model.addAttribute(AppConstants.ERR_MSG_KEY, AppConstants.ERR_MSG_VALUE_DELETE);
	    }
    	return "redirect:/dashboard";
    }
	@GetMapping("/search")
	@ResponseBody
    public List<DashboardResponse> searchPosts(@RequestParam("query") String query) {
		Integer userId = (Integer) session.getAttribute(AppConstants.SESSION_USER_ID);
        return blogService.searchPosts(userId,query);
    }
	@GetMapping("/comments")
	public String toShowComment(Model model) {
		Integer userId=(Integer)session.getAttribute(AppConstants.SESSION_USER_ID);
		List<ToShowComments> showComments = commentService.toShowComments(userId);
		model.addAttribute(AppConstants.COMMENTS, showComments);
		return AppConstants.COMMENTS;
	}
	@GetMapping("/deleteComment/{id}")
	public String deleteComment(@PathVariable Integer id,Model model) {
		boolean flag = commentService.deletePost(id);
		if (flag) {
	        model.addAttribute(AppConstants.SUCC_MSG_KEY, AppConstants.SUCC_MSG_VALUE_DELETE_COMMENT);
	    } else {
	        model.addAttribute(AppConstants.ERR_MSG_KEY, AppConstants.ERR_MSG_VALUE_DELETE_COMMENT);
	    }
		return "redirect:/comments";
	}
}
