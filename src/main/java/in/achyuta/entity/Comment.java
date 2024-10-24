package in.achyuta.entity;

import java.time.LocalDate;


import org.hibernate.annotations.CreationTimestamp;

import in.achyuta.constants.AppConstants;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = AppConstants.COMMENT_ENTITY_TABLE_NAME)
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer commentId;
	private String commentorName;
	private String commentorEmail;
	@Lob
	private String commentContent;
	@CreationTimestamp
	private LocalDate createdOn;
	
	@ManyToOne
	@JoinColumn(name = AppConstants.COMMENT_ENTITY_JOIN_COLOUMN_FK)
	private Post post;
	
	
	

}
