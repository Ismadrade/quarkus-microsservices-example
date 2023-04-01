package br.com.ismadrade.core.usecase.impl;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.port.CustomerPort;
import br.com.ismadrade.core.usecase.FindCustomerByIdUseCase;

public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {

    private final CustomerPort customerPort;

    public FindCustomerByIdUseCaseImpl(CustomerPort customerPort) {
        this.customerPort = customerPort;
    }

    @Override
    public Customer execute(Long id) {
        return customerPort.findCustomerById(id);
    }
}
