package com.AlexRozhkovan.demospingboot_snsz.config.mapper;

import com.AlexRozhkovan.demospingboot_snsz.domain.Supplier;
import com.AlexRozhkovan.demospingboot_snsz.dto.supplierDTO.SupplierGetDTO;
import com.AlexRozhkovan.demospingboot_snsz.dto.supplierDTO.SupplierCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper (componentModel = "spring")
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    SupplierGetDTO toGetDTO(Supplier supplier);
    SupplierCreateDTO toSetDTO(Supplier supplier);

    Supplier toSupplier(SupplierGetDTO supplierGetDTO);
    Supplier toSupplier1(SupplierCreateDTO supplierCreateDTO);

    Collection<SupplierGetDTO> listToGetDto(Collection <Supplier> list );
    Collection<SupplierCreateDTO> listToSetDto(Collection <Supplier> list );




}
