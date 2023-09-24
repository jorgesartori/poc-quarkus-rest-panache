package com.github.jorgesartori.rest;

import com.github.jorgesartori.business.AddressBC;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/address")
public class AddressResource {

	@Inject
	AddressBC bc;

	@GET
	@Path("/{cep}")
	@Produces(MediaType.TEXT_PLAIN)
	public String address(@PathParam("cep") String cep) {
		return bc.address(cep);
	}
}
