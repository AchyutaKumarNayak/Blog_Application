package in.achyuta.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.achyuta.constants.AppConstants;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
