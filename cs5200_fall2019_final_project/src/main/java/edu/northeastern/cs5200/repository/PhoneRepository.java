package edu.northeastern.cs5200.repository;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {

}
