package com.AlexRozhkovan.demospingboot_snsz.dto.addressDTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class AddressReadDTO {

    @Schema(description = "Id of the Address.",
            example = "33",
            required = true)
    private long id;
    @Schema(description = "Country of the Supplier.",
            example = "Georg",
            required = true)
    private String country;
    @Schema(description = "City name of the Supplier.",
            example = "Anderson",
            required = true)
    private String city;
    @Schema(description = "ZIP code of the Supplier.",
            example = " 8-800-555-35-35",
            required = true)
    private String zipCode;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }
}
