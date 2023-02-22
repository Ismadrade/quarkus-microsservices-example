package br.com.ismadrade.core.usecase.impl;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.port.CustomerPort;
import br.com.ismadrade.core.usecase.FindAllCustomerUseCase;

import java.util.List;

public class FindAllCustomerUseCaseImpl  implements FindAllCustomerUseCase {

    private final CustomerPort customerPort;

    public FindAllCustomerUseCaseImpl(CustomerPort customerPort) {
        this.customerPort = customerPort;
    }

    @Override
    public List<Customer> execute() {
        return customerPort.findAllCustomers();
    }
}
