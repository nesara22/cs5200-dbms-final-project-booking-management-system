package edu.northeastern.cs5200.repository;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Integer>{

}
