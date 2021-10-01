package com.AlexRozhkovan.demospingboot_snsz.dto.personDTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class PersonGetDTO {

    @Schema(description = "Id of the person.",
            example = "33",
            required = true)
    private long id;
    @Schema(description = "Name of the person.",
            example = "Georg",
            required = true)
    private String firstName;
    @Schema(description = "Lastname name of the person.",
            example = "Anderson",
            required = true)
    private String lastName;
    @Schema(description = "Phone of the person.",
            example = " 8-800-555-35-35",
            required = true)
    private String phoneNumber;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}
