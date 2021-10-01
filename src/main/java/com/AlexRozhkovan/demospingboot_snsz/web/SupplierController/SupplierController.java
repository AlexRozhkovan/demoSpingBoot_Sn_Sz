package com.AlexRozhkovan.demospingboot_snsz.web.SupplierController;

import com.AlexRozhkovan.demospingboot_snsz.domain.Supplier;
import com.AlexRozhkovan.demospingboot_snsz.dto.supplierDTO.SupplierReadDTO;
import com.AlexRozhkovan.demospingboot_snsz.dto.supplierDTO.SupplierCreateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/default")
public interface SupplierController {

    @Operation(summary = "Get all Suppliers", description = "endpoint for getting all suppliers", tags = {"Supplier"})
    List<Supplier> getAll();

    @Operation(summary = "Get supplier by Id", description = "endpoint for getting supplier by ID", tags = {"Supplier"})
    SupplierReadDTO getById(@PathVariable long id);


    @Operation(summary = "Add a new supplier", description = "endpoint for creating an supplier", tags = {"Supplier"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Supplier created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Supplier already exists")})
    SupplierCreateDTO saveSupplier(SupplierCreateDTO supplierCreateDTO);

  /*  @PostMapping("/persons")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new Person", description = "endpoint for creating an Person", tags = {"Person"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "409", description = "Person already exists"),
            @ApiResponse(responseCode = "201", description = "Person created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
    })
    Person savePerson(Person person);

    @PostMapping("/addresses")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new Address", description = "endpoint for creating an Address", tags = {"Address"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "409", description = "Address already exists"),
            @ApiResponse(responseCode = "201", description = "Address created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
    })
    Address saveAddress(Address address);*/

}
