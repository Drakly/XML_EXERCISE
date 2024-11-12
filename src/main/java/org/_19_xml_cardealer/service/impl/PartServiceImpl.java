package org._19_xml_cardealer.service.impl;

import jakarta.xml.bind.JAXBException;
import org._19_xml_cardealer.data.entities.Part;
import org._19_xml_cardealer.data.entities.Supplier;
import org._19_xml_cardealer.data.repositories.PartRepository;
import org._19_xml_cardealer.data.repositories.SupplierRepository;
import org._19_xml_cardealer.service.PartService;
import org._19_xml_cardealer.service.dtos.imports.PartSeedDto;
import org._19_xml_cardealer.service.dtos.imports.PartSeedRootDto;
import org._19_xml_cardealer.util.ValidationUtil;
import org._19_xml_cardealer.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PartServiceImpl implements PartService {


    private static final String FILE_IMPORT_PATH = "src/main/resources/xml/parts.xml";


    private final SupplierRepository supplierRepository;

    private final PartRepository partRepository;

    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    private final XmlParser xmlParser;

    public PartServiceImpl(SupplierRepository supplierRepository, PartRepository partRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.supplierRepository = supplierRepository;
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedParts() throws JAXBException {
        if (this.partRepository.count() == 0) {
            PartSeedRootDto partSeedRootDto = this.xmlParser.parse(PartSeedRootDto.class, FILE_IMPORT_PATH);
            for (PartSeedDto partSeedDto : partSeedRootDto.getPartSeedDtoList()) {
                if (!this.validationUtil.isValid(partSeedDto)) {
                    System.out.println("invalid data");
                    continue;
                }
                Part part = this.modelMapper.map(partSeedDto, Part.class);
                part.setSupplier(getRandomSupplier());
                this.partRepository.saveAndFlush(part);

            }
        }
    }

    private Supplier getRandomSupplier() {
        return this.supplierRepository
                .findById(
                        ThreadLocalRandom.current().nextLong(1, this.supplierRepository.count() + 1)
                )
                .get();
    }
}
