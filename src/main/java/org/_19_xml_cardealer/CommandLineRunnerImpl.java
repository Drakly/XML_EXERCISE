package org._19_xml_cardealer;

import org._19_xml_cardealer.service.PartService;
import org._19_xml_cardealer.service.SupplierService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final SupplierService supplierService;

    private final PartService partService;



    public CommandLineRunnerImpl(SupplierService supplierService, PartService partService) {
        this.supplierService = supplierService;
        this.partService = partService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.supplierService.seedSupplier();
        this.partService.seedParts();
    }
}
