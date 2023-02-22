package br.com.ismadrade.core.port;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.usecase.parameter.EditCustomerParameters;
import br.com.ismadrade.entrypoints.dto.CustomerDto;

import java.util.List;


public interface CustomerPort {
    Customer createNewCustomer(final Customer customer);
    List<Customer> findAllCustomers();
    Customer findCustomerById(Long id);
    Customer changeCustomer(final EditCustomerParameters editCustomerParameters);
    void deleteCustomer(Long id);

}
