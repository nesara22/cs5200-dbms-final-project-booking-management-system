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
import edu.northeastern.cs5200.models.Hotel;
import edu.northeastern.cs5200.models.Review;
import edu.northeastern.cs5200.models.RoomDetails;

@RestController
public class HotelController {

  @Autowired
  HotelManagementDao dao;

  @CrossOrigin
  @PostMapping("/api/hotel")
  public Hotel createHotel(@RequestBody Hotel hotel) {
    dao.createHotel(hotel);
    return hotel;
  }

  @CrossOrigin
  @GetMapping("/api/hotels")
  public List<Hotel> findAllHotels() {
    return dao.findAllHotels();
  }


  @CrossOrigin
  @GetMapping("/api/hotel/id/{id}")
  public Hotel findHotelById(@PathVariable("id") int id) {
    return dao.findHotelById(id);
  }

  @CrossOrigin
  @GetMapping("/api/hotel-rooms/hotel-id/{id}")
  public List<RoomDetails> findRoomsByHotelId(@PathVariable("id") int id) {
    return dao.findRoomsByHotelId(id);
  }


}
