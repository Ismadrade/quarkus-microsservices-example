package br.com.ismadrade.core.usecase.impl;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.port.CustomerPort;
import br.com.ismadrade.core.usecase.RegisterCustomerUseCase;
import br.com.ismadrade.core.usecase.parameter.RegisterCustomerParameters;

import javax.inject.Named;

@Named
public class RegisterCustomerUseCaseImpl implements RegisterCustomerUseCase {

    private final CustomerPort customerPort;

    public RegisterCustomerUseCaseImpl(CustomerPort customerPort) {
        this.customerPort = customerPort;
    }

    @Override
    public Customer execute(RegisterCustomerParameters parameters) {

        final String name = parameters.getName();
        final String phone = parameters.getPhone();
        final String email = parameters.getEmail();
        final String address = parameters.getAddress();
        final Long age  = parameters.getAge();
        final Customer customer = new Customer(null, name, email, address, age);

        if(phone != null && !phone.equals(""))
            customer.setPhone(phone);

        return customerPort.createNewCustomer(customer);
    }
}
