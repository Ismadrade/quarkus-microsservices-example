package br.com.ismadrade.infrastructure.config;

import br.com.ismadrade.core.usecase.RegisterCustomerUseCase;
import br.com.ismadrade.core.usecase.impl.RegisterCustomerUseCaseImpl;
import br.com.ismadrade.infrastructure.provider.CustomerProvider;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

@Dependent
public class CustomerConfiguration {

    @Produces
    public RegisterCustomerUseCase registerCustomerUseCase(CustomerProvider customerProvider){
        return new RegisterCustomerUseCaseImpl(customerProvider);
    }
}
