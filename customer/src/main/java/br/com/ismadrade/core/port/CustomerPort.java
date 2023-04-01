package br.com.ismadrade.core.port;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.usecase.parameter.EditCustomerParameters;

import java.util.List;


public interface CustomerPort {
    Customer createNewCustomer(final Customer customer);
    List<Customer> findAllCustomers();
    Customer findCustomerById(Long id);
    Customer changeCustomer(final Customer customer);
    void deleteCustomer(Long id);

}
