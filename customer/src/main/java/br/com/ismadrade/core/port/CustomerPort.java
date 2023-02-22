package br.com.ismadrade.core.port;

import br.com.ismadrade.core.domain.Customer;

@FunctionalInterface
public interface CustomerPort {
    Customer createNewCustomer(final Customer customer);
}
