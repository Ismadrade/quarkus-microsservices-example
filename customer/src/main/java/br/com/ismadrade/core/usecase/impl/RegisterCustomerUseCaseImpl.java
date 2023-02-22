package br.com.ismadrade.core.usecase.impl;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.gateway.CustomerGateway;
import br.com.ismadrade.core.usecase.RegisterCustomerUseCase;
import br.com.ismadrade.core.usecase.parameter.RegisterCustomerParameters;

import javax.inject.Named;

@Named
public class RegisterCustomerUseCaseImpl implements RegisterCustomerUseCase {

    private final CustomerGateway registerCustomerGateway;

    public RegisterCustomerUseCaseImpl(CustomerGateway registerCustomerGateway) {
        this.registerCustomerGateway = registerCustomerGateway;
    }

    @Override
    public Customer execute(RegisterCustomerParameters parameters) {

        final String name = parameters.getName();
        final String phone = parameters.getPhone();
        final String email = parameters.getEmail();
        final String address = parameters.getAddress();
        final Long age  = parameters.getAge();
        final Customer customer = new Customer(null, name, phone, email, address, age);

        return registerCustomerGateway.createNewCustomer(customer);
    }
}
