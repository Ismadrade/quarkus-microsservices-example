package br.com.ismadrade.adapters.inbound.controller;


import br.com.ismadrade.adapters.inbound.dto.ProductDto;
import br.com.ismadrade.adapters.inbound.mapper.ProductMapper;
import br.com.ismadrade.adapters.outbound.ProductPersistencePortImpl;
import br.com.ismadrade.application.core.domain.Product;
import br.com.ismadrade.application.ports.in.ProductServicePort;
import br.com.ismadrade.application.ports.out.ProductPersistencePort;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/products")
public class ProductController {

    @Inject
    ProductServicePort productServicePort;

    @Inject
    ProductMapper mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDto> findAllProducts(){
        return mapper.of(productServicePort.getAllProducts());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDto findProductById(@PathParam("id") Long id){
        return mapper.of(productServicePort.findProductById(id));
    }

    @POST
    @Transactional
    public Response saveProduct(ProductDto productDto){
        try {
            return Response.ok().entity(productServicePort.create(mapper.from(productDto))).build();
        }catch (Exception e) {
            return Response.ok().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response changeProduct(@PathParam("id") Long id, ProductDto productDto){
        try {
            productServicePort.changeProduct(id, mapper.from(productDto));
            return Response.ok().build();
        }catch (Exception e) {
            return Response.ok().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response removeProduct(@PathParam("id") Long id){
        try {
            productServicePort.deleteProduct(id);
            return Response.ok().build();
        }catch (Exception e) {
            return Response.ok().build();
        }
    }
}
