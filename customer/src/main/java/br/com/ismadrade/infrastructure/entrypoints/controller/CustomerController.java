package br.com.ismadrade.infrastructure.entrypoints.controller;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.usecase.RegisterCustomerUseCase;
import br.com.ismadrade.core.usecase.parameter.RegisterCustomerParameters;
import br.com.ismadrade.infrastructure.entrypoints.dto.CustomerDto;
import br.com.ismadrade.infrastructure.provider.CustomerProvider;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/customers")
public class CustomerController {

    @Inject
    CustomerProvider customerProvider;

    @Inject
    RegisterCustomerUseCase registerCustomerUseCase;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDto> findAllCustomers(){
        return customerProvider.findAllCustomers();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerDto findCustomerById(@PathParam("id") Long id){
        return customerProvider.findCustomerById(id);
    }

    @POST
    @Transactional
    public Response saveCustomer(CustomerDto customerDto){
        try {
            final RegisterCustomerParameters parameters = new RegisterCustomerParameters(customerDto.getName(), customerDto.getPhone(), customerDto.getEmail(), customerDto.getAddress(), customerDto.getAge());
            Customer customer = registerCustomerUseCase.execute(parameters);
            return Response.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response changeCustomer(@PathParam("id") Long id, CustomerDto customerDto){
        try {
            customerProvider.changeCustomer(id, customerDto);
            return Response.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteCustomer(@PathParam("id") Long id){
        try {
            customerProvider.deleteCustomer(id);
            return Response.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
