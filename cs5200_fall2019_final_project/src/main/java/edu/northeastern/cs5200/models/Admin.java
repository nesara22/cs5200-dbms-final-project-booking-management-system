package edu.northeastern.cs5200.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin extends User {

  private boolean isActive;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  public Admin() {
    super();
  }

  public Admin(String firstName, String middleName, String lastName, String username, String password, Date dob,
               String gender, String email, String street, String city, String state, String zip, String phone,
               Role role) {
    super(firstName, middleName, lastName, username, password, dob, gender, email, street, city, state, zip, phone, role);
    // TODO Auto-generated constructor stub
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }
}
