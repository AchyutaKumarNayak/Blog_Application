package in.achyuta.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchCriteriaFilter {
	
	private Integer postId;
	private String title;
	private String description;
	private LocalDate createdOn;

}
