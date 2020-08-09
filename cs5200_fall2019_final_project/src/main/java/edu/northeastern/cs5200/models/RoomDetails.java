package edu.northeastern.cs5200.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class RoomDetails {

  @Id
  @GeneratedValue
          (strategy = GenerationType.IDENTITY)
  private int id;


  private int beds;
  private RoomType type;
  private boolean isBooked;
  private double price;
  private boolean smoking;
  private boolean complementaryBreakfast;
  private boolean parking;
  private boolean isRefundable;
  @JsonFormat(pattern="MM/dd/yyyy", timezone="UTC")
  private Date checkInDate;
  @JsonFormat(pattern="MM/dd/yyyy", timezone="UTC")
  private Date checkOutDate;
  private int occupancy;
  private int roomNumber;
  boolean isActive;


  public RoomDetails() {
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public RoomDetails(int beds, RoomType type, boolean isBooked, double price, boolean smoking,
                     boolean complementaryBreakfast, boolean parking, boolean isRefundable,
                     Date checkInDate, Date checkOutDate, int occupancy, int roomNumber,
                     String city) {
    this.beds = beds;
    this.type = type;
    this.isBooked = isBooked;
    this.price = price;
    this.smoking = smoking;
    this.complementaryBreakfast = complementaryBreakfast;
    this.parking = parking;
    this.isRefundable = isRefundable;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    this.occupancy = occupancy;
    this.roomNumber = roomNumber;

  }


  @OneToMany(mappedBy = "roomDetails1", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  public List<Booking> bookingDetails;

  @ManyToOne
  @JsonIgnore
  public Hotel hotel1;

  /*public void getBookingDetails(Booking booking) {
    this.bookingDetails.add(booking);
    *//*if (booking.getRoomDetails() != this) {
      booking.setRoomDetails(this);
    }*//*
  }*/


  public List<Booking> getBookingDetails() {
    return bookingDetails;
  }

  public void setBookingDetails(List<Booking> bookingDetails) {
    this.bookingDetails = bookingDetails;
   /* if(!bookingDetails.getRoomDetails.contains(this)){
      bookingDetails.getRoomDetails().add(this);
    }*/
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
  }



  public Hotel getHotel() {
    return hotel1;
  }


  public void setHotel(Hotel hotel) {
    this.hotel1 = hotel;
    /*if (!hotel.getRoomDetails().contains(this)) {
      hotel.getRoomDetails().add(this);
    }*/
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getBeds() {
    return beds;
  }

  public void setBeds(int beds) {
    this.beds = beds;
  }

  public RoomType getType() {
    return type;
  }

  public void setType(RoomType type) {
    this.type = type;
  }

  public boolean isBooked() {
    return isBooked;
  }

  public void setBooked(boolean booked) {
    isBooked = booked;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public boolean isSmoking() {
    return smoking;
  }

  public void setSmoking(boolean smoking) {
    this.smoking = smoking;
  }

  public boolean isComplementaryBreakfast() {
    return complementaryBreakfast;
  }

  public void setComplementaryBreakfast(boolean complementaryBreakfast) {
    this.complementaryBreakfast = complementaryBreakfast;
  }

  public boolean isParking() {
    return parking;
  }

  public void setParking(boolean parking) {
    this.parking = parking;
  }

  public boolean isRefundable() {
    return isRefundable;
  }

  public void setRefundable(boolean refundable) {
    isRefundable = refundable;
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

  public int getOccupancy() {
    return occupancy;
  }

  public void setOccupancy(int occupancy) {
    this.occupancy = occupancy;
  }
}

