package com.AlexRozhkovan.demospingboot_snsz.repository;

import com.AlexRozhkovan.demospingboot_snsz.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    
    List<Address> findByCountry(String country);
    List<Address> findByCity(String city);
    List<Address> findByZipCode(String zipCode);
}