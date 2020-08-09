package edu.northeastern.cs5200.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

import edu.northeastern.cs5200.daos.HotelManagementDao;
import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.Hotel;
import edu.northeastern.cs5200.models.RoomDetails;
import edu.northeastern.cs5200.models.User;

@RestController
public class RoomController {

  @Autowired
  HotelManagementDao dao;

  @CrossOrigin
  @PostMapping("/api/room")
  public RoomDetails createRoom(@RequestBody RoomDetails room) {
    dao.createRoomDetails(room);
    return room;
  }

  @CrossOrigin
  @GetMapping("/api/rooms")
  public List<RoomDetails> findAllRooms() {
    return dao.findAllRooms();
  }

  @CrossOrigin
  @GetMapping("/api/room/id/{id}")
  public RoomDetails findRoomById(@PathVariable("id") int id) {
    return dao.findRoomById(id);
  }

  @CrossOrigin
  @PutMapping("/api/update-room/{id}")
  public void updateCustomer(
          @PathVariable("id") int id,
          @RequestBody RoomDetails newRoom
  ) {
    dao.updateRoomDetails(newRoom);
  }

  @CrossOrigin
  @PostMapping("/api/update-room-booking/{id}/{isBooking}")
  public RoomDetails updateIsBooking(
          @PathVariable("id") int id,
          @PathVariable("isBooking") String isBooking
  ) {
    return dao.updateIsBookingRoom(id,isBooking);
  }

  @CrossOrigin
  @GetMapping("/api/room/availability/{checkInDate}/{checkOutDate}/{occupancy}/{city}")
  public List<RoomDetails> findRoomById(@PathVariable("checkInDate") Date checkInDate,
                                        @PathVariable("checkOutDate") Date checkOutDate,
                                        @PathVariable("occupancy") int occupancy,
                                       @PathVariable("city") String city)
  {
    return dao.findRoomsByAvailabilityAndCity(checkInDate,checkOutDate,occupancy,city);
  }


  @CrossOrigin
  @GetMapping("/api/room-hotel/id/{id}")
  public Hotel findHotelByRoomId(@PathVariable("id") int id) {
    return dao.findHotelByRoomId(id);
  }


}