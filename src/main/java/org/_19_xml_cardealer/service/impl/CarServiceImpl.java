package org._19_xml_cardealer.service.impl;

import jakarta.xml.bind.JAXBException;
import org._19_xml_cardealer.service.CarService;
import org._19_xml_cardealer.util.XmlParser;

public class CarServiceImpl implements CarService {

    private final XmlParser xmlParser;

    public CarServiceImpl(XmlParser xmlParser) {
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedCars() throws JAXBException {
    }

}
