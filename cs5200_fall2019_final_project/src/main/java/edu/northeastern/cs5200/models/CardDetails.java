package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CardDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String cardNumber;
  private String expiryDate;
/*	@ManyToOne()
	@JsonIgnore
	private User cardOwner;*/

  @ManyToOne
  @JsonIgnore
  public Customer customer;

  public CardDetails() {

  }

  public Customer getCardOwner() {
    return customer;
  }

  public void setCardOwner(Customer cardOwner) {
    this.customer = cardOwner;
    if (!cardOwner.getListCardDetails().contains(this)) {
      cardOwner.getListCardDetails().add(this);
    }
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }
}
