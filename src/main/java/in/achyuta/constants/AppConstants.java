package in.achyuta.constants;

public class AppConstants {
	
	public static final String SESSION_USER_ID              ="userId";
	public static final String POSTS                        ="posts";
	public static final String DASHBOARD                    ="dashboard";
	public static final String ADD_POST                     ="addPost";
	public static final String SUCC_MSG_KEY                 ="succMsg";
	public static final String ERR_MSG_KEY                  ="errMsg";
	public static final String SUCC_MSG_VALUE_ADD           ="Post Added Successfully";
	public static final String ERR_MSG_VALUE_ADD            ="Some error occurred during add post";
	public static final String EDIT_POST                    ="editPost";
	public static final String SUCC_MSG_VALUE_DELETE        ="Post Deleted Successfully";
	public static final String ERR_MSG_VALUE_DELETE         ="Some error occurred during deletion";
	public static final String COMMENTS                     ="comments";
	public static final String SUCC_MSG_VALUE_DELETE_COMMENT="Comment Deleted Successfully";
	public static final String ERR_MSG_VALUE_DELETE_COMMENT ="Some error occurred during deletion";
	public static final String INDEX                        ="index";
	public static final String SEARCH_QUERY                 ="query";
	public static final String POST_CONTROLLER_POST         ="post";
	public static final String POST_CONTROLLER_COMMENTS     ="comments";
	public static final String POST_CONTROLLER_POST_DETAILS ="post-details";
	public static final String USER_CONTROLLER_USER         ="user";
	public static final String USER_CONTROLLER_REGISTRATION ="registration";
	public static final String SUCC_MSG_VALUE_REGISTRATION  ="Regestration Succesfull";
	public static final String ERR_MSG_VALUE_REGISTRATION   ="Choose Unique Email";
	public static final String USER_CONTROLLER_LOGIN        ="login";
	public static final String USER_CONTROLLER_FLAG_SUCCESS ="success";
	public static final String USER_SERVICE_IMPL_FLAG_FAILURE ="Invalid Credentials";
	public static final String COMMENT_REPO_DELETE_QUERY      ="DELETE FROM Comment c WHERE c.commentId= :commentId";
	public static final String POST_REPO_DELETE_QUERY         ="DELETE FROM Post p WHERE p.postId = :postId";
	public static final String USER_ENTITY_TABLE_NAME         ="USER_TBL";
	public static final String COMMENT_ENTITY_TABLE_NAME      ="COMMENT_TBL";
	public static final String POST_ENTITY_TABLE_NAME         ="POST_TBL";
	public static final String COMMENT_ENTITY_JOIN_COLOUMN_FK ="post_id";
	public static final String POST_ENTITY_JOIN_COLOUMN_FK    ="user_id";
	public static final String USER_ENTITY_JOIN_COLOUMN_FK    ="user";
	
	
	public static final String USER_CONTROLLER_MAPPING_REGISTER="/register";
	public static final String USER_CONTROLLER_MAPPING_LOGIN="/login";
	
	public static final String BLOG_CONTROLLER_MAPPING_LOGOUT="/logout";
	public static final String BLOG_CONTROLLER_MAPPING_DASHBOARD="/dashboard";
	public static final String BLOG_CONTROLLER_MAPPING_ADD_POST="/addPost";
	public static final String BLOG_CONTROLLER_MAPPING_UPDATE_POST="/updatePost";
	public static final String BLOG_CONTROLLER_MAPPING_SEARCH="/search";
	public static final String BLOG_CONTROLLER_MAPPING_COMMENTS="/comments";
	public static final String BLOG_CONTROLLER_REDIRECT_DASHBOARD="redirect:/dashboard";
	public static final String BLOG_CONTROLLER_REDIRECT_COMMENTS="redirect:/comments";
	public static final String BLOG_CONTROLLER_MAPPING_EDIT_POST_BY_ID="/editPost/{id}";
	public static final String BLOG_CONTROLLER_MAPPING_DELETE_POST_BY_ID="/deletePost/{id}";
	public static final String BLOG_CONTROLLER_MAPPING_DELETE_COMMENT_BY_ID="/deleteComment/{id}";
	
	
	public static final String POST_CONTROLLER_REQUEST_MAPPING="/posts";
	public static final String POST_CONTROLLER_MAPPING_GET_POST_BY_ID="/{id}";
	public static final String POST_CONTROLLER_MAPPING_ADD_COMMENT="/{id}/comments";
	public static final String POST_CONTROLLER_REDIRECT_POSTS="redirect:/posts/";
	public static final String POST_CONTROLLER_REDIRECT_POSTS_FLAG="?success=true";
	
	
	public static final String INDEX_CONTROLLER_MAPPING="/";
	public static final String INDEX_CONTROLLER_MAPPING_FILTER="/filter";

	


	
	
	
	
	
	
	private AppConstants() {}
	
	

}
