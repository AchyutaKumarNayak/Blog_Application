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

import in.achyuta.constants.AppConstants;
import in.achyuta.entity.Comment;
import in.achyuta.entity.Post;
import in.achyuta.service.CommentService;
import in.achyuta.service.PostService;

@Controller
@RequestMapping(AppConstants.POST_CONTROLLER_REQUEST_MAPPING)
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;
	
	
	@GetMapping(AppConstants.POST_CONTROLLER_MAPPING_GET_POST_BY_ID)
	public String getPostById(@PathVariable Integer id,Model model) {
		
		Post postByPostId = postService.getPostByPostId(id);
		List<Comment> topTwoCommentsByPost = commentService.getTopTwoCommentsByPost(postByPostId, 2);
		model.addAttribute(AppConstants.POST_CONTROLLER_POST, postByPostId);
		model.addAttribute(AppConstants.POST_CONTROLLER_COMMENTS, topTwoCommentsByPost);
		
		return AppConstants.POST_CONTROLLER_POST_DETAILS;
		
	}
	@PostMapping(AppConstants.POST_CONTROLLER_MAPPING_ADD_COMMENT)
    public String addComment(@PathVariable Integer id, @ModelAttribute Comment comment) {
        Post post = postService.getPostByPostId(id);
        comment.setPost(post);
        commentService.save(comment);
        return AppConstants.POST_CONTROLLER_REDIRECT_POSTS + id + AppConstants.POST_CONTROLLER_REDIRECT_POSTS_FLAG; // Redirect to the same page with success flag
    }

}
