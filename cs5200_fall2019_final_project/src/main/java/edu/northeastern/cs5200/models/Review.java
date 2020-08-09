package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @ManyToOne
  @JsonIgnore
  public Customer customer1;

  public Customer getCustomer() {
    return this.customer1;
  }

  public void setCustomer(Customer customer) {
    this.customer1 = customer;
   /* if (!customer.getReviewDetails().contains(this)) {
      customer.getReviewDetails().add(this);
    }*/
  }

  public Review() {
  }
}
