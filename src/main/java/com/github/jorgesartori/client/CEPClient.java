package com.github.jorgesartori.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.github.jorgesartori.dto.AddressDTO;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "https://viacep.com.br/")
public interface CEPClient {

	@GET
	@Path("/ws/{cep}/json/")
	@Produces(MediaType.APPLICATION_JSON)
	AddressDTO getCEP(@PathParam("cep") String cep);

}
