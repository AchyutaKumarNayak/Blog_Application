package in.achyuta.entity;

import java.util.List;

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
@Table(name = "USER_TBL")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Post> posts;

}
