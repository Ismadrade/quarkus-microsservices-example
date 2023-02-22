package br.com.ismadrade.config;

import br.com.ismadrade.core.usecase.RegisterCustomerUseCase;
import br.com.ismadrade.core.usecase.impl.RegisterCustomerUseCaseImpl;
import br.com.ismadrade.infrastructure.service.CustomerService;
import io.quarkus.arc.DefaultBean;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

@Dependent
public class CustomerConfiguration {

    @Produces
    public RegisterCustomerUseCase registerCustomerUseCase(CustomerService customerService){
        return new RegisterCustomerUseCaseImpl(customerService);
    }
}
