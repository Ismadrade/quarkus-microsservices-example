package br.com.ismadrade.core.gateway;

import br.com.ismadrade.core.domain.Customer;

@FunctionalInterface
public interface CustomerGateway {
    Customer createNewCustomer(final Customer customer);
}
