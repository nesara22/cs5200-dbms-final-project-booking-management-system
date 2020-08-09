package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.util.List;

import edu.northeastern.cs5200.models.Admin;
import edu.northeastern.cs5200.models.Booking;
import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.Hotel;
import edu.northeastern.cs5200.models.Rating;
import edu.northeastern.cs5200.models.Review;
import edu.northeastern.cs5200.models.RoomDetails;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.Vendor;

public interface HotelManagementDao {

  public static HotelManagementDao getInstance() {
    HotelManagementDao instance = null;
    if (instance == null)
      instance = new HotelManagementImpl();
    return instance;
  }

  public Vendor createVendor(Vendor vendor);

  public Admin createAdmin(Admin admin);

  public Customer createCustomer(Customer customer);

  public Hotel createHotel(Hotel hotel);

  public Review createReview(Review review);

  public RoomDetails createRoomDetails(RoomDetails room);

  public Booking createBooking(Booking booking);

  public List<User> findAllUsers();

  public List<Vendor> findAllVendors();

  public List<Admin> findAllAdmins();

  public List<Customer> findAllCustomers();

  public List<Hotel> findAllHotels();

  public List<RoomDetails> findAllRooms();

  public List<Review> findAllReviews();

  public Customer findCustomerById(int id);

  public RoomDetails findRoomById(int id);

  public User findUserByUsername(String username);

  public Hotel findHotelById(int id);

  public Hotel findHotelByName(String hotelName);

  public void updateCustomer(Customer customer);

  List<Booking> findAllBookings();

  List<Booking> findAllBookingsForUser(int id);

  List<Booking> findAllBookingsForRoom(int id);

  Booking findBookingById(int id);

  void enrollCustomerForBooking(int bId, int cId);

  void updateRoomDetails(RoomDetails roomDetails);

  RoomDetails updateIsBookingRoom(int roomId, String isBooking);

  List<Hotel> hotelsByVendors(int id);

  List<RoomDetails> findRoomsByAvailabilityAndCity(Date checkInDate, Date checkOutDate, int occupancy, String city);

  Hotel findHotelByRoomId(int roomId);

  void deleteBookingForUser(int customerId, int bookingId);

  List<RoomDetails> findRoomsByHotelId(int hotelId);

}

