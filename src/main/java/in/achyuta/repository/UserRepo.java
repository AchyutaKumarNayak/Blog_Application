package in.achyuta.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import in.achyuta.entity.User;


public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User findByEmail(String email);
	public User findByEmailAndPassword(String email,String password);

}
