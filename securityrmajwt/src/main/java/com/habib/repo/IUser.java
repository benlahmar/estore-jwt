package com.habib.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habib.entities.User;
/**
 * 
 * @author habib
 *
 */

public interface IUser extends JpaRepository<User, Long>{

	 Optional<User> findByUsername(String log);
}
