package br.com.ismadrade.core.usecase;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.usecase.parameter.RegisterCustomerParameters;

@FunctionalInterface
public interface RegisterCustomerUseCase {

    Customer execute(final RegisterCustomerParameters parameters);
}
