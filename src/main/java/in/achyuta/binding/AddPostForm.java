package in.achyuta.binding;

import lombok.Data;

@Data
public class AddPostForm {
	private Integer postId;
	private String title;
	private String description;
	private String content;

}
