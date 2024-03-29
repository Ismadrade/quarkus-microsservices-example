package br.com.ismadrade.entrypoints.controller;

import br.com.ismadrade.core.usecase.*;
import br.com.ismadrade.core.usecase.parameter.EditCustomerParameters;
import br.com.ismadrade.core.usecase.parameter.RegisterCustomerParameters;
import br.com.ismadrade.entrypoints.dto.CustomerDto;
import br.com.ismadrade.entrypoints.mapper.CustomerMapper;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/customers")
public class CustomerController {

    @Inject
    RegisterCustomerUseCase registerCustomerUseCase;

    @Inject
    CustomerMapper customerMapper;

    @Inject
    EditCustomerUseCase editCustomerUseCase;

    @Inject
    FindAllCustomerUseCase findAllCustomerUseCase;

    @Inject
    FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Inject
    RemoveCustomerUseCase removeCustomerUseCase;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDto> findAllCustomers(){
        return customerMapper.of(findAllCustomerUseCase.execute());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerDto findCustomerById(@PathParam("id") Long id){
        return customerMapper.of(findCustomerByIdUseCase.execute(id));
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveCustomer(CustomerDto customerDto){
        final RegisterCustomerParameters parameters = new RegisterCustomerParameters(customerDto.getName(), customerDto.getPhone(), customerDto.getEmail(), customerDto.getAddress(), customerDto.getAge());
        CustomerDto customer = customerMapper.of(registerCustomerUseCase.execute(parameters));
        return Response.ok().entity(customer).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response changeCustomer(@PathParam("id") Long id, CustomerDto customerDto){
        final EditCustomerParameters parameters = new EditCustomerParameters(id, customerDto.getName(), customerDto.getPhone(), customerDto.getEmail(), customerDto.getAddress(), customerDto.getAge());
        CustomerDto customer = customerMapper.of(editCustomerUseCase.execute(parameters));
        return Response.ok().entity(customer).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteCustomer(@PathParam("id") Long id){
        removeCustomerUseCase.execute(id);
        return Response.ok().build();
    }
}
