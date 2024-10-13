package in.achyuta.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.achyuta.entity.Comment;
import in.achyuta.entity.Post;
import in.achyuta.service.CommentService;
import in.achyuta.service.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;
	
	
	@GetMapping("/{id}")
	public String getPostById(@PathVariable Integer id,Model model) {
		
		Post postByPostId = postService.getPostByPostId(id);
		List<Comment> topTwoCommentsByPost = commentService.getTopTwoCommentsByPost(postByPostId, 2);
		model.addAttribute("post", postByPostId);
		model.addAttribute("comments", topTwoCommentsByPost);
		
		return "post-details";
		
	}
	@PostMapping("/{id}/comments")
    public String addComment(@PathVariable Integer id, @ModelAttribute Comment comment) {
        Post post = postService.getPostByPostId(id);
        comment.setPost(post);
        commentService.save(comment);
        return "redirect:/posts/" + id + "?success=true"; // Redirect to the same page with success flag
    }

}
