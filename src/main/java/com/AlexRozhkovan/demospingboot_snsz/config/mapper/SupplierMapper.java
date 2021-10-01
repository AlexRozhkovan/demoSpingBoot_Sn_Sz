package com.AlexRozhkovan.demospingboot_snsz.config.mapper;

import com.AlexRozhkovan.demospingboot_snsz.domain.Supplier;
import com.AlexRozhkovan.demospingboot_snsz.dto.supplierDTO.SupplierDeleteDTO;
import com.AlexRozhkovan.demospingboot_snsz.dto.supplierDTO.SupplierReadDTO;
import com.AlexRozhkovan.demospingboot_snsz.dto.supplierDTO.SupplierCreateDTO;
import com.AlexRozhkovan.demospingboot_snsz.dto.supplierDTO.SupplierUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper (componentModel = "spring")
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    SupplierReadDTO toReadDTO(Supplier supplier);
    SupplierCreateDTO toSaveDTO(Supplier supplier);
    SupplierUpdateDTO toUpdateDTO(Supplier supplier);
    SupplierDeleteDTO toDeleteDTO(Supplier supplier);

    Supplier toSaveSupplier(SupplierReadDTO supplierReadDTO);
    Supplier toReadSupplier(SupplierCreateDTO supplierCreateDTO);
    Supplier toUpdateSupplier(SupplierUpdateDTO supplierUpdateDTO);
    Supplier toDeleteSupplier(SupplierDeleteDTO supplierDeleteDTO);

    List<SupplierReadDTO> toReadDtoList(List<Supplier> suppliers);






}
