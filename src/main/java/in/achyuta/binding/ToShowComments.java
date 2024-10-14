package in.achyuta.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ToShowComments {
	
	private Integer postId;
	private Integer commentId;
	private String commentContent;
	private String title;
	private String commentorEmail;
	private LocalDate createdOn;
	
	

}
