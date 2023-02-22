package br.com.ismadrade.infrastructure.config;

import br.com.ismadrade.core.usecase.*;
import br.com.ismadrade.core.usecase.impl.*;
import br.com.ismadrade.infrastructure.provider.CustomerProvider;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

@Dependent
public class CustomerConfiguration {

    @Produces
    public RegisterCustomerUseCase registerCustomerUseCase(CustomerProvider customerProvider){
        return new RegisterCustomerUseCaseImpl(customerProvider);
    }

    @Produces
    public EditCustomerUseCase editCustomerUseCase(CustomerProvider customerProvider){
        return new EditCustomerUseCaseImpl(customerProvider);
    }

    @Produces
    public FindAllCustomerUseCase findAllCustomerUseCase(CustomerProvider customerProvider){
        return new FindAllCustomerUseCaseImpl(customerProvider);
    }

    @Produces
    public FindCustomerByIdUseCase findCustomerByIdUseCase(CustomerProvider customerProvider){
        return new FindCustomerByIdUseCaseImpl(customerProvider);
    }

    @Produces
    public RemoveCustomerUseCase removeCustomerUseCase(CustomerProvider customerProvider){
        return new RemoveCustomerUseCaseImpl(customerProvider);
    }
}
