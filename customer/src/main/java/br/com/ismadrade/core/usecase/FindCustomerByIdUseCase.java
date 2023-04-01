package br.com.ismadrade.core.usecase;

import br.com.ismadrade.core.domain.Customer;

public interface FindCustomerByIdUseCase {
    Customer execute(Long id);
}
