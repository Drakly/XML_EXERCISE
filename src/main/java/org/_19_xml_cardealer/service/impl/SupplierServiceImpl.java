package org._19_xml_cardealer.service.impl;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org._19_xml_cardealer.data.entities.Supplier;
import org._19_xml_cardealer.data.repositories.SupplierRepository;
import org._19_xml_cardealer.service.SupplierService;
import org._19_xml_cardealer.service.dtos.imports.SupplierSeedDto;
import org._19_xml_cardealer.service.dtos.imports.SupplierSeedRootDto;
import org._19_xml_cardealer.util.ValidationUtil;
import org._19_xml_cardealer.util.ValidationUtilImpl;
import org._19_xml_cardealer.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;

@Service
public class SupplierServiceImpl implements SupplierService {

    private static final String FILE_IMPORT_PATH = "src/main/resources/xml/suppliers.xml";

    private final SupplierRepository supplierRepository;

    private final XmlParser xmlParser;

    private final ValidationUtil validationUtil;

    private final ModelMapper modelMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedSupplier() throws JAXBException {
        if (this.supplierRepository.count() == 0) {
            SupplierSeedRootDto supplierSeedRootDto = xmlParser.parse(SupplierSeedRootDto.class, FILE_IMPORT_PATH);
            for (SupplierSeedDto supplierSeedDto : supplierSeedRootDto.getSupplierSeedDtoList()) {
                if (!this.validationUtil.isValid(supplierSeedDto)) {
                    System.out.println("Invalid supplier data");

                    continue;
                }

                Supplier supplier = this.modelMapper.map(supplierSeedDto, Supplier.class);
                this.supplierRepository.saveAndFlush(supplier);

            }

        }

    }
}
