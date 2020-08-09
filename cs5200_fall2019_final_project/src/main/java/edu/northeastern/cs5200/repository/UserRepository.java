package edu.northeastern.cs5200.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.User;

public interface UserRepository extends CrudRepository<User, Integer>{

  @Query("SELECT s FROM User s where s.username=:username")
  User findUserByUsername(@Param("username")String username);

}
