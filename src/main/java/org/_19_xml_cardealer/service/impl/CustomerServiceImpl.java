package org._19_xml_cardealer.service.impl;

import jakarta.xml.bind.JAXBException;
import org._19_xml_cardealer.data.repositories.CustomerRepository;
import org._19_xml_cardealer.service.CustomersService;
import org._19_xml_cardealer.service.dtos.exports.CustomerOrderedDto;
import org._19_xml_cardealer.service.dtos.exports.CustomerOrderedRootDto;
import org._19_xml_cardealer.util.XmlParser;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomersService {

    private final XmlParser xmlParser;

    private final ModelMapper modelMapper;

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(XmlParser xmlParser, ModelMapper modelMapper, CustomerRepository customerRepository) {
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
    }


    @Override
    public void seedCustomers() throws JAXBException {

    }

    @Override
    public void exportOrderedCustomers() {
        List<CustomerOrderedDto> customerOrderedDtos = this.customerRepository.findAllByOrderByBirthDateAscIsYoungDriver()
                .stream()
                .map(c -> this.modelMapper.map(c, CustomerOrderedDto.class))
                .collect(Collectors.toList());

        CustomerOrderedDto customerOrderedDto = new CustomerOrderedDto();
        //TODO Finish the export
    }
}
