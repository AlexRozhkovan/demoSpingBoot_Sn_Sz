package com.AlexRozhkovan.demospingboot_snsz.dto.supplierDTO;

import com.AlexRozhkovan.demospingboot_snsz.domain.Address;
import com.AlexRozhkovan.demospingboot_snsz.domain.Person;
import io.swagger.v3.oas.annotations.media.Schema;

public class SupplierGetDTO {

    @Schema(description = "Id of the supplier.",
            example = "33",
            required = true)
    private long id;
    @Schema(description = "Name of the supplier.",
            example = "Georg",
            required = true)
    private String name;
    @Schema(description = "Address name of the supplier.",
            example = "#4 Address",
            required = true)
    private Address address;
    @Schema(description = "Person of the supplier.",
            example = " #1 Person",
            required = true)
    private Person person;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }
}
