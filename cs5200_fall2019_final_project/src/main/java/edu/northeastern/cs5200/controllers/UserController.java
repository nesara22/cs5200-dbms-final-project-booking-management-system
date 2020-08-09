package edu.northeastern.cs5200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.HotelManagementDao;
import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.Hotel;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.Vendor;

import java.util.List;


@RestController
public class UserController {

  @RequestMapping("/api/hello/string")
  public String sayHello() {
    return "Hello!";
  }

  @Autowired
  HotelManagementDao dao;


  @CrossOrigin
  @GetMapping("/api/customer/id/{id}")
  public User findUserById(@PathVariable("id") int id) {
    return dao.findCustomerById(id);
  }

  @CrossOrigin
  @GetMapping("/api/customers")
  public List<Customer> findAllCustomers() {
    // HotelManagementDao dao = HotelManagementDao.getInstance();
    // return dao.findAllCustomers();
    return dao.findAllCustomers();
  }

  @CrossOrigin
  @GetMapping("/api/vendors")
  public List<Vendor> findAllVendors() {
    return dao.findAllVendors();
  }

  @CrossOrigin
  @GetMapping("/api/username/{username}")
  public User findUserByUsername(@PathVariable("username") String username) {
    return dao.findUserByUsername(username);
  }

  @CrossOrigin
  @PostMapping("/api/customer")
  public Customer createCustomer(@RequestBody Customer customer) {
    dao.createCustomer(customer);
    return customer;
  }

  @CrossOrigin
  @PutMapping("/api/update-customer/{id}")
  public void updateCustomer(
          @PathVariable("id") int id,
          @RequestBody Customer newCustomer
  ) {

    dao.updateCustomer(newCustomer);
  }

  @CrossOrigin
  @GetMapping("/api/vendor/{id}")
  public List<Hotel> findHotelsByVendorId(@PathVariable("id") int id) {
    return dao.hotelsByVendors(id);
  }

 /* @CrossOrigin
  @DeleteMapping("/api/delete-booking/{customerId}/{bookingId}")
  void deleteBookingForUser(@PathVariable("customerId") int customerId,
                            @PathVariable("bookingId") int bookingId) {
    dao.deleteBookingForUser(customerId,bookingId);
  }*/

 @CrossOrigin
  @DeleteMapping(value = "/api/delete-booking/{customerId}/{bookingId}")
  public void deleteBookingForUser(@PathVariable int customerId,
                                   @PathVariable int bookingId) {
    dao.deleteBookingForUser(customerId,bookingId);
  }


}
