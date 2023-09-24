package com.github.jorgesartori.repository;

import com.github.jorgesartori.entity.Address;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddressRepository implements PanacheRepository<Address> {

	public Address findByCep(String cep) {
		return find("cep", cep).firstResult();

	}

}
