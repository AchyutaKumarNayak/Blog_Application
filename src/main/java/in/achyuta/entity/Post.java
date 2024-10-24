package in.achyuta.entity;

import java.time.LocalDate;

import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.achyuta.constants.AppConstants;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = AppConstants.POST_ENTITY_TABLE_NAME)
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer postId;
	private String title;
	private String description;
	@Lob
	private String content;
	@CreationTimestamp
	private LocalDate createdOn;
	@UpdateTimestamp
	private LocalDate updatedOn;
	
	
	@ManyToOne()
	@JoinColumn(name = AppConstants.POST_ENTITY_JOIN_COLOUMN_FK)
	private User user;
	@OneToMany(mappedBy = "post",cascade = CascadeType.REMOVE,orphanRemoval = true)
	private List<Comment> comments;
	
	

}
