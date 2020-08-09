package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
public class Hotel {

  @Id
  @GeneratedValue
          (strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String description;
  private Rating rating;
  private Boolean swimmingPoolAvailability;
  private Boolean fitnessCentre;
  private String city;

  private String street;
  private String zip;
  private PaymentMethod paymentMethod;

  @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  private List<Phone> phones;

  @OneToMany(mappedBy = "hotel1", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @Fetch(value = FetchMode.SUBSELECT)
  private List<RoomDetails> rooms;

  @ManyToOne
  @JsonIgnore
  public Vendor owner;


  /*public void listRoomDetails(RoomDetails roomDetails) {
    this.roomDetails.add(roomDetails);
    if (roomDetails.getHotel() != this) {
      roomDetails.setHotel(this);
    }
  }*/

  public User getOwner() {
    return owner;
  }

  public void getOwner(Vendor owner) {
    this.owner = owner;
  }

  public Hotel() {

  }

  public Hotel(String name, String description, Rating rating, Boolean swimmingPoolAvailability,
               Boolean fitnessCentre, String street, String zip, PaymentMethod paymentMethod,
               List<Phone> phones,String city) {
    this.name = name;
    this.description = description;
    this.rating = rating;
    this.swimmingPoolAvailability = swimmingPoolAvailability;
    this.fitnessCentre = fitnessCentre;
    this.street = street;
    this.zip = zip;
    this.paymentMethod = paymentMethod;
    this.phones = phones;
    this.city=city;
  }



  /*public List<RoomDetails> getRooms() {
    return this.rooms;
  }*/

  public void setRooms(List<RoomDetails> roomDetails) {
    this.rooms = roomDetails;
  }

  public List<Phone> getPhones() {
    return phones;
  }

  public void setPhones(List<Phone> phones) {
    this.phones = phones;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Rating getRating() {
    return rating;
  }

  public void setRating(Rating rating) {
    this.rating = rating;
  }

  public Boolean getSwimmingPoolAvailability() {
    return swimmingPoolAvailability;
  }

  public void setSwimmingPoolAvailability(Boolean swimmingPoolAvailability) {
    this.swimmingPoolAvailability = swimmingPoolAvailability;
  }

  public Boolean getFitnessCentre() {
    return fitnessCentre;
  }

  public void setFitnessCentre(Boolean fitnessCentre) {
    this.fitnessCentre = fitnessCentre;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }



}
