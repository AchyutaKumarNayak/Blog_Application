package in.achyuta.entity;

import java.util.List;

import in.achyuta.constants.AppConstants;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = AppConstants.USER_ENTITY_TABLE_NAME)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	@OneToMany(mappedBy = AppConstants.USER_ENTITY_JOIN_COLOUMN_FK,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Post> posts;

}
