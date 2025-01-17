package com.AlexRozhkovan.demospingboot_snsz.repository;

import com.AlexRozhkovan.demospingboot_snsz.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {


}