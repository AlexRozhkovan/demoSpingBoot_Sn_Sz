package com.AlexRozhkovan.demospingboot_snsz.service.supplierService;

import com.AlexRozhkovan.demospingboot_snsz.domain.Supplier;
import com.AlexRozhkovan.demospingboot_snsz.repository.SupplierRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@Slf4j
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;

    public SupplierServiceImpl(SupplierRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Supplier saveSupplier(@RequestBody Supplier supplier) {
        log.info("saveSupplier() - start: supplier = {}", supplier);
        var savedSupplier = repository.save(supplier);
        log.info("saveSupplier() - end: savedSupplier() = {}", savedSupplier.getId());
        return savedSupplier;
    }

    @Override
    public List<Supplier> getAllSuppliers()
    {
        log.info("repository.findAll() - start");
        var findAllUsers = repository.findAll();
        log.info("findAll() - end");
        return findAllUsers;
    }

    @Override
    public Supplier getSupplierById(Long id)
    {   log.info("repository.findById() - start");
        var supplier = repository.findById(id)
                .orElseThrow(() ->  new EntityNotFoundException("Supplier not found with id = " + id));

        if (supplier.getDeleted())
        {   log.error("Supplier is Deleted - yes");
            throw new EntityNotFoundException("Supplier was deleted with id = " + id);
        }
        log.info("findById() - end");
        return supplier;
    }

    @Override
    public List<Supplier> getSupplierByName(String name)
    {
        List<Supplier> suppliers = repository.findByName(name);
        log.info("getSupplierByName - succeed");
        if (suppliers.toArray().length < 1)
            throw new EntityNotFoundException("Customer not found with name = " + name);
        else
            return suppliers;
    }


    @Override
    public Supplier updateSupplier(Supplier supplier)
    {   log.info("updateSupplier - succeed");
        return repository.findById(supplier.getId())
                .map(entity -> {
                    entity.setName(supplier.getName());
                    entity.setAddress(supplier.getAddress());
                    entity.setPersons(supplier.getPersons());
                    return repository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id = " + supplier.getId()));
    }

    @Override
    public void removeSupplierById(Long id)
    {   log.info("removeSupplierById - succeed");
        repository.findById(id)
                .map(supplier -> {
                    supplier.setDeleted(Boolean.TRUE);
                    return repository.save(supplier);
                })
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id = " + id));
    }

    @Override
    public void removeAllSuppliers()
    {
        log.info("removeAllSupplier - succeed");
        repository.deleteAll();
    }

}
