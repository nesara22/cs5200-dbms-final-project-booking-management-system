package edu.northeastern.cs5200.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import edu.northeastern.cs5200.models.Booking;
import edu.northeastern.cs5200.models.Customer;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

  @Query("SELECT s FROM Booking s where s.customer.id=:userId")
  List<Booking> findBookingForUser(@Param("userId")int userId);

  /*@Query("SELECT s FROM Booking s where s.user.id=:userId")
  Customer findBookingForUser(@Param("userId")int userId); */
}
