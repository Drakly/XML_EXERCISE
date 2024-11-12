package org._19_xml_cardealer.data.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(name = "is_imported")
    private boolean isImported;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }
}
