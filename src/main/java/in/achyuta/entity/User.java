package in.achyuta.entity;

import java.util.List;


import in.achyuta.constants.AppConstants;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
