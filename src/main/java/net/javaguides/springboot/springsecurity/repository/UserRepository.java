package net.javaguides.springboot.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
//	User findById(long id);
	public User findById(long id) throws Exception;
	// Optional<User> findByEmail(String email);
	 Optional<User> findByResetToken(String resetToken);
}
