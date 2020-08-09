package edu.northeastern.cs5200.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import edu.northeastern.cs5200.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

  @Query("SELECT s FROM Customer s where s.username=:username")
  Customer findCustomerByUsername(@Param("username")String username);
}
