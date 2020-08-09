package edu.northeastern.cs5200.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

import edu.northeastern.cs5200.models.Hotel;
import edu.northeastern.cs5200.models.RoomDetails;

public interface RoomDetailsRepository extends CrudRepository<RoomDetails, Integer> {

  @Query("SELECT r from RoomDetails r join Hotel h on r.hotel1.id=h.id " +
          "where r.checkInDate >= :checkInDate and r.checkOutDate <= :checkOutDate and " +
          "r.occupancy=:occupancy and r.isBooked=FALSE and r.isActive=TRUE and h.city=:city")
  List<RoomDetails> findRoomsForDatesAndCity(@Param("checkInDate") Date checkInDate,
                                       @Param("checkOutDate") Date checkOutDate,
                                       @Param("occupancy") int occupancy,
                                       @Param("city") String city
  );


  @Query("SELECT h from RoomDetails r join Hotel h on r.hotel1.id=h.id " +
          "where r.id=:id")
  Hotel findHotelByRoomId(@Param("id") int id
  );

  @Transactional
  @Modifying
  @Query("DELETE from Booking where customer.id=:customerId and id=:bookingId")
  void deleteBookingForCustomer(@Param("bookingId") int bookingId,
                         @Param("customerId") int customerId
  );


}
