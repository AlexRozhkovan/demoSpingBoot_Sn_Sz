package com.AlexRozhkovan.demospingboot_snsz.repository;

import com.AlexRozhkovan.demospingboot_snsz.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    List<Supplier> findByName(String name);
}
