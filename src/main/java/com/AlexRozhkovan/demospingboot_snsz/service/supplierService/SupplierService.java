package com.AlexRozhkovan.demospingboot_snsz.service.supplierService;

import com.AlexRozhkovan.demospingboot_snsz.domain.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SupplierService {


    /**
     * Save new supplier.
     *
     * @param requestForSave {@link com.AlexRozhkovan.demospingboot_snsz.domain.Supplier}.
     * @return DTO representation for saved customer.
     */
    Supplier saveSupplier(Supplier requestForSave);

    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(final Long id);

    List<Supplier> getSupplierByName(final String name);

    Supplier updateSupplier(final Supplier supplier);

    void removeSupplierById(final Long id);

    void removeAllSuppliers();

}
