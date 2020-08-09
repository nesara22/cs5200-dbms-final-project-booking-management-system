package edu.northeastern.cs5200.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import edu.northeastern.cs5200.models.Hotel;
import edu.northeastern.cs5200.models.Vendor;

public interface VendorRepository extends CrudRepository<Vendor, Integer>{

  @Query("SELECT h FROM Hotel h where h.owner.id=:id")
  List<Hotel> findHotelsOfVendors(@Param("id") int id);

}
