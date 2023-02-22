package br.com.ismadrade.core.usecase;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.usecase.parameter.EditCustomerParameters;

public interface EditCustomerUseCase {

    Customer execute(final EditCustomerParameters parameters);
}
