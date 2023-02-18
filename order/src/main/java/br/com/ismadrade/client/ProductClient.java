package br.com.ismadrade.client;

import br.com.ismadrade.dto.CustomerDto;
import br.com.ismadrade.dto.ProductDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/products")
@RegisterRestClient(configKey = "product-api")
@ApplicationScoped
public interface ProductClient {

    @GET
    @Path("/{id}")
    ProductDto getProductById(@PathParam("id") Long id);
}
