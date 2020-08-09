package edu.northeastern.cs5200.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
public class Vendor extends User {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  //@Fetch(value = FetchMode.SUBSELECT)
  private List<Hotel> ownedHotels;

  public List<Hotel> getOwnedHotels() {
    return ownedHotels;
  }

  public void setOwnedHotels(List<Hotel> ownedHotels) {
    this.ownedHotels = ownedHotels;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Vendor() {
  }

  public Vendor(String firstName, String middleName, String lastName, String username, String password, Date dob,
                String gender, String email, String street, String city, String state, String zip, String phone, Role role) {
    super(firstName, middleName, lastName, username, password, dob, gender, email, street, city, state, zip, phone, role);
    // TODO Auto-generated constructor stub

  }
}
