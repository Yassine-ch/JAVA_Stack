package com.yassine.ProjectManager.repositories;

import java.util.List;
import java.util.Optional;

import com.yassine.ProjectManager.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	Optional <User> findByEmail(String email);
	List <User> findAll();

}