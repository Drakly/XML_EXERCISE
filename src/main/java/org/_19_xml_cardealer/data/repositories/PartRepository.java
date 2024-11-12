package org._19_xml_cardealer.data.repositories;

import org._19_xml_cardealer.data.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {




}
