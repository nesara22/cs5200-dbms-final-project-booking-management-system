package edu.northeastern.cs5200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import edu.northeastern.cs5200.daos.HotelManagementDao;
import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.Review;

@RestController
public class ReviewController {

  @Autowired
  HotelManagementDao dao;

  @CrossOrigin
  @PostMapping("/api/review")
  public Review createReview(@RequestBody Review review) {
    dao.createReview(review);
    return review;
  }

  @CrossOrigin
  @GetMapping("/api/reviews")
  public List<Review> findAllReviews() {
    return dao.findAllReviews();
  }
}
