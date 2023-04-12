package br.com.ismadrade.adapters.config;

import br.com.ismadrade.application.core.service.ProductServicePortImpl;
import br.com.ismadrade.application.ports.out.ProductPersistencePort;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;


@Dependent
public class BeanConfiguration {

    @Produces
    public ProductServicePortImpl productServicePort(ProductPersistencePort productPersistencePort){
        return new ProductServicePortImpl(productPersistencePort);
    }
}
