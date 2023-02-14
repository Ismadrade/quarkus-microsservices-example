package br.com.ismadrade.controller;


import br.com.ismadrade.dto.ProductDto;
import br.com.ismadrade.service.ProductService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/products")
public class ProductController {

    @Inject
    ProductService productService;

    @GET
    public List<ProductDto> findAllProducts(){
        return productService.getAllProducts();
    }

    @POST
    @Transactional
    public Response saveProduct(ProductDto productDto){
        try {
            productService.createNewProduct(productDto);
            return Response.ok().build();
        }catch (Exception e) {
            return Response.ok().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response changeProduct(@PathParam("id") Long id, ProductDto productDto){
        try {
            productService.changeProduct(id, productDto);
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
            productService.deleteProduct(id);
            return Response.ok().build();
        }catch (Exception e) {
            return Response.ok().build();
        }
    }
}
