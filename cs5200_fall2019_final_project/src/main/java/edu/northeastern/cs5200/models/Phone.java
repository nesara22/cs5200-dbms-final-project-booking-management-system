package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
public class Phone {

  @Id
  @GeneratedValue
          (strategy = GenerationType.IDENTITY)
  private int id;
  private String number;
  private boolean isPrimary;

  @ManyToOne
  @JsonIgnore
  public Hotel hotel;

  public Phone() {

  }

  public Phone(String number, boolean isPrimary) {
    this.number = number;
    this.isPrimary = isPrimary;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public boolean isPrimary() {
    return isPrimary;
  }

  public void setPrimary(boolean isPrimary) {
    this.isPrimary = isPrimary;
  }
}
