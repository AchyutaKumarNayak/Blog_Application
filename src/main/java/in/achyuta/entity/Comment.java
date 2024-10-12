package in.achyuta.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "COMMENT_TBL")
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
	@JoinColumn(name = "post_id")
	private Post post;
	
	
	

}
