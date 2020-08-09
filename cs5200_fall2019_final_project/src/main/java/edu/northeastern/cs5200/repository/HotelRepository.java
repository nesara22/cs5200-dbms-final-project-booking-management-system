package edu.northeastern.cs5200.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.Hotel;
import edu.northeastern.cs5200.models.RoomDetails;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {

  @Query("SELECT h FROM Hotel h where h.name=:name")
  Hotel findHotelByName(@Param("name") String name);

  @Query("SELECT r from RoomDetails r join Hotel h on r.hotel1.id=h.id " +
          "where r.hotel1.id=:id")
  List<RoomDetails> findRoomsForHotel(@Param("id") int id);


}
