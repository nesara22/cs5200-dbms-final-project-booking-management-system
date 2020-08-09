package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repository.*;

@Component
public class HotelManagementImpl implements HotelManagementDao {
  @Autowired
  HotelManagementDao hotelManagementdao;
  @Autowired
  UserRepository userRepo;
  @Autowired
  VendorRepository vendorRepo;
  @Autowired
  AdminRepository adminRepo;
  @Autowired
  CustomerRepository customerRepo;
  @Autowired
  HotelRepository hotelRepo;
  @Autowired
  ReviewRepository reviewRepo;
  @Autowired
  RoomDetailsRepository roomDetailsRepo;
  @Autowired
  BookingRepository bookingRepo;


  private static HotelManagementDao instance = null;

  HotelManagementImpl() {
  }

  @Override
  public Vendor createVendor(Vendor vendor) {
    return vendorRepo.save(vendor);
  }

  @Override
  public Admin createAdmin(Admin admin) {
    return adminRepo.save(admin);
  }

  @Override
  public Customer createCustomer(Customer customer) {
    return customerRepo.save(customer);
  }

  @Override
  public Hotel createHotel(Hotel hotel) {
    return hotelRepo.save(hotel);
  }

  @Override
  public Review createReview(Review review) {
    return reviewRepo.save(review);
  }

  @Override
  public RoomDetails createRoomDetails(RoomDetails room) {
    return roomDetailsRepo.save(room);
  }

  @Override
  public Booking createBooking(Booking booking) {
    return bookingRepo.save(booking);
  }

  @Override
  public List<User> findAllUsers() {
    return null;
  }

  @Override
  public List<Vendor> findAllVendors() {
    return (List<Vendor>) vendorRepo.findAll();
  }

  @Override
  public List<Admin> findAllAdmins() {
    return (List<Admin>) adminRepo.findAll();
  }

  @Override
  public List<Customer> findAllCustomers() {
    return (List<Customer>) customerRepo.findAll();
  }

  @Override
  public List<Hotel> findAllHotels() {

    return (List<Hotel>) hotelRepo.findAll();
  }

  @Override
  public List<RoomDetails> findAllRooms() {
    return (List<RoomDetails>) roomDetailsRepo.findAll();
  }

  @Override
  public List<Review> findAllReviews() {
    return (List<Review>) reviewRepo.findAll();
  }

  @Override
  public Customer findCustomerById(int id) {
    return (Customer) customerRepo.findById(id).get();
  }

  @Override
  public RoomDetails findRoomById(int id) {
    return roomDetailsRepo.findById(id).get();
  }

  @Override
  public User findUserByUsername(String username) {
    return userRepo.findUserByUsername(username);
  }

  @Override
  public Hotel findHotelById(int id) {
    return hotelRepo.findById(id).get();
  }

  @Override
  public Hotel findHotelByName(String hotelName) {
    return hotelRepo.findHotelByName(hotelName);
  }

  @Override
  public void updateCustomer(Customer customer) {
    customerRepo.save(customer);
  }

  @Override
  public List<Booking> findAllBookings() {
    return (List<Booking>) bookingRepo.findAll();
  }

  @Override
  public List<Booking> findAllBookingsForUser(int id) {
    return bookingRepo.findBookingForUser(id);
  }

  @Override
  public List<Booking> findAllBookingsForRoom(int id) {
    return null;
  }

  @Override
  public Booking findBookingById(int id) {
    return bookingRepo.findById(id).get();
  }

  @Override
  public void enrollCustomerForBooking(int bId, int cId) {
    Booking booking = bookingRepo.findById(bId).get();
    Customer customer = customerRepo.findById(cId).get();
    //booking.setUserForBooking(user);
    //studentRepository.save(student);
  }

  @Override
  public void updateRoomDetails(RoomDetails roomDetails) {
    roomDetailsRepo.save(roomDetails);
  }

  @Override
  public RoomDetails updateIsBookingRoom(int roomId, String isBooking) {

  	boolean booking = false;
  	if (isBooking.toLowerCase().equals("true"))
		{
			booking = true;
		}
    RoomDetails room = roomDetailsRepo.findById(roomId).get();
    room.setBooked(booking);

    return  roomDetailsRepo.save(room);
  }

  @Override
  public List<Hotel> hotelsByVendors(int id) {
    return vendorRepo.findHotelsOfVendors(id);
  }

  @Override
  public List<RoomDetails> findRoomsByAvailabilityAndCity(Date checkInDate, Date checkOutDate,
                                                          int occupancy, String city) {
    return roomDetailsRepo.findRoomsForDatesAndCity(checkInDate, checkOutDate, occupancy, city);
  }

  @Override
  public Hotel findHotelByRoomId(int roomId) {
    return roomDetailsRepo.findHotelByRoomId(roomId);
  }

  @Override
  public void deleteBookingForUser(int customerId, int bookingId) {
    roomDetailsRepo.deleteBookingForCustomer(bookingId, customerId);
  }

  @Override
  public List<RoomDetails> findRoomsByHotelId(int hotelId) {
    return hotelRepo.findRoomsForHotel(hotelId);
  }

}
