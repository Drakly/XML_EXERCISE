package org._19_xml_cardealer.data.repositories;

import org._19_xml_cardealer.data.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Set<Customer> findAllByOrderByBirthDateAscIsYoungDriver();
}
