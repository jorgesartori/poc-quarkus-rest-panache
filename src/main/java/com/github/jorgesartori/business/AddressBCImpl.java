package com.github.jorgesartori.business;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.github.jorgesartori.client.CEPClient;
import com.github.jorgesartori.entity.Address;
import com.github.jorgesartori.mapper.AddressMapper;
import com.github.jorgesartori.repository.AddressRepository;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AddressBCImpl implements AddressBC {

	@Inject
	@RestClient
	CEPClient client;

	@Inject
	AddressRepository repository;

	@Inject
	AddressMapper mapper;

	@Override
	@Transactional
	public String address(String cep) {

		Log.info("searching CEP by client");
		var clientAddressDTO = client.getCEP(cep);

		Log.info("converting DTO to Entity");
		Address entityToSave = mapper.toEntity(clientAddressDTO);

		Log.info("saving Address in database");
		repository.persistAndFlush(entityToSave);

		Log.info("getting Address by database");

		var entityFound = repository.findByCep(clientAddressDTO.cep);
		Log.info("Address ID: " + entityFound.id);

		Log.info("converting Entity to DTO");
		var addressConvertedDTO = mapper.toDTO(entityFound);

		Log.info("deleting from database");
		repository.delete(entityFound);

		Log.info("returning DTO to REST");
		return addressConvertedDTO.logradouro + " - " + addressConvertedDTO.bairro + " - " + addressConvertedDTO.localidade
				+ " - " + addressConvertedDTO.uf;
	}

}
