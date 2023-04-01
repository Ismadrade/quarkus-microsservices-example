package br.com.ismadrade.core.usecase;


import br.com.ismadrade.core.domain.Customer;

import java.util.List;

public interface FindAllCustomerUseCase {
    List<Customer> execute();
}
