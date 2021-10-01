package com.AlexRozhkovan.demospingboot_snsz.web;

import com.AlexRozhkovan.demospingboot_snsz.config.mapper.SupplierMapper;
import com.AlexRozhkovan.demospingboot_snsz.domain.Supplier;
import com.AlexRozhkovan.demospingboot_snsz.dto.supplierDTO.SupplierGetDTO;
import com.AlexRozhkovan.demospingboot_snsz.dto.supplierDTO.SupplierCreateDTO;
import com.AlexRozhkovan.demospingboot_snsz.service.supplierService.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class SupplierRestControllerImpl implements SupplierRestController {


    private final SupplierService supplierService;

    public SupplierRestControllerImpl(SupplierService supplierService)
    {
        this.supplierService = supplierService;
    }

    @Override
    public List<Supplier> getAll()
    {
        return supplierService.getAllSuppliers();
    }

    @Override
    public SupplierGetDTO getById(@PathVariable long id)
    {
        Supplier supplier = supplierService.getSupplierById(id);
        return SupplierMapper.INSTANCE.toGetDTO(supplier);
    }

    @Override
    public SupplierCreateDTO saveSupplier(@RequestBody SupplierCreateDTO requestForSave)
    {
        Supplier supplier = SupplierMapper.INSTANCE.toSupplier1(requestForSave);
        return SupplierMapper.INSTANCE.toSetDTO(supplierService.saveSupplier(supplier));
    }

}