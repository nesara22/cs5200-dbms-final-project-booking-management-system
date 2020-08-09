package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private boolean goldBatch;

  @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private List<CardDetails> listCardDetails;

  @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonIgnoreProperties("customer")
  private List<Booking> bookingDetails;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer1", fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  private List<Review> reviewDetails;

  public Customer() {
  	super();
  }

  public Customer(String firstName, String middleName){
    super(firstName, middleName);
  }

  public Customer(String firstName, String middleName, String lastName, String username, String password, Date dob,
                  String gender, String email, String street, String city, String state, String zip, String phone,
                  Role role) {
    super(firstName, middleName, lastName, username, password, dob, gender, email, street, city, state, zip, phone, role);
    // TODO Auto-generated constructor stub
  }

  public boolean isGoldBatch() {
    return goldBatch;
  }

  public void setGoldBatch(boolean goldBatch) {
    this.goldBatch = goldBatch;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }




 /* public void listReviewDetails(Review review) {
    this.reviewDetails.add(review);
    if (review.getCustomer() != this) {
      review.setCustomer(this);
    }
  }
*/
  public void listCardDetails(CardDetails cardDetail) {
    this.listCardDetails.add(cardDetail);
    if (cardDetail.getCardOwner() != this) {
      cardDetail.setCardOwner(this);
    }
  }

 /* public void listBookingDetails(Booking booking) {
    this.bookingDetails.add(booking);
    *//*if (booking.getBookingCustomer() != this) {
      booking.setBookingCustomer(this);
    }*//*
  }*/


  public List<CardDetails> getListCardDetails() {
    return listCardDetails;
  }

  public void setListCardDetails(List<CardDetails> listCardDetails) {
    this.listCardDetails = listCardDetails;
  }


  public List<Booking> getBookingDetails() {
    return bookingDetails;
  }

  public void setBookingDetails(List<Booking> booking) {
    this.bookingDetails = booking;
  }

  public List<Review> getReviewDetails() {
    return this.reviewDetails;
  }

  public void setReviewDetails(List<Review> reviewDetails) {
    this.reviewDetails = reviewDetails;
  }
}
