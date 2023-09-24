package com.github.jorgesartori.mapper;

import org.mapstruct.Mapper;

import com.github.jorgesartori.dto.AddressDTO;
import com.github.jorgesartori.entity.Address;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Mapper(componentModel = "cdi", uses = { Address.class, AddressDTO.class, PanacheEntity.class })
public interface AddressMapper {

	Address toEntity(AddressDTO dto);

	AddressDTO toDTO(Address entity);

}
