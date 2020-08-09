package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @JsonFormat(pattern="MM/dd/yyyy", timezone="UTC")
  private Date checkInDate;
  @JsonFormat(pattern="MM/dd/yyyy", timezone="UTC")
  private Date checkOutDate;
  private int numberOfAdults;

  public Booking() {
  }

  public Booking(Date checkInDate, Date checkOutDate, int numberOfAdults) {
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    this.numberOfAdults = numberOfAdults;
  }


  @ManyToOne
  @JsonIgnoreProperties("bookingDetails")
  public Customer customer;


  @ManyToOne
  @JsonIgnoreProperties("bookingDetails")
  public RoomDetails roomDetails1; /*= new RoomDetails();*/

 /* public Customer getBookingCustomer() {
    return customer;
  }*/

  public void setBookingCustomer(Customer customer) {
    this.customer = customer;
    if (!customer.getBookingDetails().contains(this)) {
      customer.getBookingDetails().add(this);
    }
  }


 /* public RoomDetails getRoomDetails() {
    return this.roomDetails1;
  }*/

  public void setRoomDetails(RoomDetails roomDetails) {
    this.roomDetails1 = roomDetails;
   /* if (!roomDetails.getBookingDetails().contains(this)) {
      roomDetails.getBookingDetails().add(this);
    }*/
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getCheckInDate() {
    return checkInDate;
  }

  public void setCheckInDate(Date checkInDate) {
    this.checkInDate = checkInDate;
  }

  public Date getCheckOutDate() {
    return checkOutDate;
  }

  public void setCheckOutDate(Date checkOutDate) {
    this.checkOutDate = checkOutDate;
  }

  public int getNumberOfAdults() {
    return numberOfAdults;
  }

  public void setNumberOfAdults(int numberOfAdults) {
    this.numberOfAdults = numberOfAdults;
  }

}
