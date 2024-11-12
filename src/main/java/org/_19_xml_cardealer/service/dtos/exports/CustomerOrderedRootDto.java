package org._19_xml_cardealer.service.dtos.exports;

import jakarta.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerOrderedRootDto implements Serializable {

    @XmlElement(name = "customers")
    private List<CustomerOrderedDto> customerOrderedDtoList;

    public List<CustomerOrderedDto> getCustomerOrderedDtoList() {
        return customerOrderedDtoList;
    }

    public void setCustomerOrderedDtoList(List<CustomerOrderedDto> customerOrderedDtoList) {
        this.customerOrderedDtoList = customerOrderedDtoList;
    }
}
