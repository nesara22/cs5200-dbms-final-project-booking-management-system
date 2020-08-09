package edu.northeastern.cs5200.models;

public enum Rating {
  ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);
  int rating;

  Rating(int i) {
    this.rating = i;
  }
}

