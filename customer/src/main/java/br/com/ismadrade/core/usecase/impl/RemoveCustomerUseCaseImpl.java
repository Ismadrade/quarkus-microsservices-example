package br.com.ismadrade.core.usecase.impl;

import br.com.ismadrade.core.port.CustomerPort;
import br.com.ismadrade.core.usecase.RemoveCustomerUseCase;

public class RemoveCustomerUseCaseImpl implements RemoveCustomerUseCase {

    private final CustomerPort customerPort;

    public RemoveCustomerUseCaseImpl(CustomerPort customerPort) {
        this.customerPort = customerPort;
    }


    @Override
    public void execute(Long id) {
        customerPort.deleteCustomer(id);
    }
}
