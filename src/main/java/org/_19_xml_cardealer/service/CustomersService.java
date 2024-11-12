package org._19_xml_cardealer.service;

import jakarta.xml.bind.JAXBException;

public interface CustomersService {

    void seedCustomers() throws JAXBException;


    void exportOrderedCustomers();

}
