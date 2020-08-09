package edu.northeastern.cs5200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import edu.northeastern.cs5200.daos.HotelManagementDao;
import edu.northeastern.cs5200.models.Booking;
import edu.northeastern.cs5200.models.RoomDetails;

@RestController
public class BookingController {

  @Autowired
  HotelManagementDao dao;

  @CrossOrigin
  @PostMapping("/api/booking")
  public Booking createBooking(@RequestBody Booking booking) {
    dao.createBooking(booking);
    return booking;
  }

  @CrossOrigin
  @GetMapping("/api/bookings")
  public List<Booking> findAllBookings() {
    return dao.findAllBookings();
  }

  @CrossOrigin
  @GetMapping("/api/bookings/customer/{id}")
  public List<Booking> findAllBookingsForUser(@PathVariable("id") int id) {
    return dao.findAllBookingsForUser(id);
  }

  @CrossOrigin
  @GetMapping("/api/bookings/room/{id}")
  public List<Booking> findAllBookingsForRoom(@PathVariable("id") int id) {
    return dao.findAllBookingsForRoom(id);
  }

  @CrossOrigin
  @GetMapping("/api/booking/id/{id}")
  public Booking findBookingById(@PathVariable("id") int id) {

    return dao.findBookingById(id);
  }

  @CrossOrigin
  @PostMapping("/api/booking/{bId}/customer/{cId}")
  public void enrollCustomerForBooking(
          @PathVariable("bId") int bId,
          @PathVariable("cId") int cId) {

    dao.enrollCustomerForBooking(bId, cId);

  }
}
