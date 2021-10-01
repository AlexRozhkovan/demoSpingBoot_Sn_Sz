package com.AlexRozhkovan.demospingboot_snsz.web.SupplierController;

import com.AlexRozhkovan.demospingboot_snsz.config.mapper.SupplierMapper;
import com.AlexRozhkovan.demospingboot_snsz.domain.Supplier;
import com.AlexRozhkovan.demospingboot_snsz.dto.supplierDTO.SupplierReadDTO;
import com.AlexRozhkovan.demospingboot_snsz.dto.supplierDTO.SupplierCreateDTO;
import com.AlexRozhkovan.demospingboot_snsz.service.supplierService.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class SupplierControllerImpl implements SupplierController {


    private final SupplierService supplierService;

    public SupplierControllerImpl(SupplierService supplierService)
    {
        this.supplierService = supplierService;
    }

    @Override
    @GetMapping("/suppliers")
    @ResponseStatus(HttpStatus.OK)
    public List<Supplier> getAll()
    {
        return supplierService.getAllSuppliers();
    }

    @Override
    @GetMapping("/suppliers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SupplierReadDTO getById(@PathVariable long id)
    {
        Supplier supplier = supplierService.getSupplierById(id);
        return SupplierMapper.INSTANCE.toReadDTO(supplier);
    }

    @Override
    @PostMapping("/suppliers")
    @ResponseStatus(HttpStatus.CREATED)
    public SupplierCreateDTO saveSupplier(@RequestBody SupplierCreateDTO requestForSave)
    {
        Supplier supplier = SupplierMapper.INSTANCE.toReadSupplier(requestForSave);
        return SupplierMapper.INSTANCE.toSaveDTO(supplierService.saveSupplier(supplier));
    }

}