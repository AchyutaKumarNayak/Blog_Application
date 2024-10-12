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
import in.achyuta.service.BlogService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BlogController {
	
	@Autowired
	private HttpSession session;
	@Autowired
	private BlogService blogService;

	
	
	
	@GetMapping("/logout")
    public String logout() {
		session.invalidate();
    	return "index";
    }
	
	@GetMapping("/dashboard")
	public String getDashboard(Model model) {
		Integer userId =(Integer)session.getAttribute("userId");
		List<DashboardResponse> dashboardRes = blogService.getDashboardRes(userId);
		model.addAttribute("posts", dashboardRes);
		return "dashboard";
	}
	@GetMapping("/addPost")
	public String addPost(Model model) {
		model.addAttribute("addPost",new AddPostForm());
		return "addPost";
	}
	@PostMapping("/addPost")
	public String handleAddPost(@ModelAttribute("addPost") AddPostForm form,Model model) {
		System.out.println(form);
		boolean status = blogService.addPost(form);
		if(status) {
			model.addAttribute("succMsg", "Post Added Successfully");
		}else {
			model.addAttribute("errMsg", "Some error occurred during add post");
		}
		return "redirect:/dashboard";
	}
	@GetMapping("/editPost/{id}")
	public String editPost(@PathVariable Integer id, Model model) {
	    AddPostForm form = blogService.editPost(id);
	    System.out.println(form);
	    model.addAttribute("addPost", form);
	    return "editPost"; 
	}
	@PostMapping("/updatePost")
	public String updatePost(@ModelAttribute("addPost") AddPostForm form, Model model) {
	    blogService.updatePost(form);
	    return "redirect:/dashboard";
	}
	@GetMapping("/deletePost/{id}")
    public String deletePost(@PathVariable Integer id,Model model) {
		boolean status = blogService.deletePost(id);
		if (status) {
	        model.addAttribute("succMsg", "Post Deleted Successfully");
	    } else {
	        model.addAttribute("errMsg", "Some error occurred during deletion");
	    }
    	return "redirect:/dashboard";
    }
	@GetMapping("/search")
	@ResponseBody
    public List<DashboardResponse> searchPosts(@RequestParam("query") String query) {
		Integer userId = (Integer) session.getAttribute("userId");
        return blogService.searchPosts(userId,query);
    }
}
