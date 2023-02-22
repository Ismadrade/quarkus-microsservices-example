package br.com.ismadrade.core.usecase.impl;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.port.CustomerPort;
import br.com.ismadrade.core.usecase.EditCustomerUseCase;
import br.com.ismadrade.core.usecase.parameter.EditCustomerParameters;

public class EditCustomerUseCaseImpl implements EditCustomerUseCase {

    private final CustomerPort customerPort;

    public EditCustomerUseCaseImpl(CustomerPort customerPort) {
        this.customerPort = customerPort;
    }

    @Override
    public Customer execute(EditCustomerParameters parameters) {
        return customerPort.changeCustomer(parameters);
    }
}
