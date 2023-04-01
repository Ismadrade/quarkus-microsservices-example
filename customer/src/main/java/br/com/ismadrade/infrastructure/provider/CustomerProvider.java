package br.com.ismadrade.infrastructure.provider;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.port.CustomerPort;
import br.com.ismadrade.core.usecase.parameter.EditCustomerParameters;
import br.com.ismadrade.entrypoints.dto.CustomerDto;
import br.com.ismadrade.infrastructure.jpa.entity.CustomerEntity;
import br.com.ismadrade.infrastructure.jpa.repository.CustomerRepository;
import br.com.ismadrade.infrastructure.mapper.CustomerMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerProvider implements CustomerPort {

    @Inject
    CustomerRepository customerRepository;

    @Inject
    CustomerMapper customerMapper;

    @Override
    public List<Customer> findAllCustomers(){
        return customerMapper.of(customerRepository
                .findAll()
                .stream()
                .collect(Collectors.toList()));
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerMapper.of(customerRepository.findById(id));
    }

    @Override
    public Customer createNewCustomer(final  Customer customer){
        customerRepository.persist(customerMapper.of(customer));
        return customer;
    }

    @Override
    public Customer changeCustomer(Customer customer){


        CustomerEntity customerEntity = customerRepository.findById(customer.getId());
        customerEntity.setName(customer.getName());
        customerEntity.setPhone(customer.getPhone().getFormattedPhone());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setAddress(customer.getAddress());
        customerEntity.setAge(customer.getAge());

        customerRepository.persist(customerEntity);
        return customer;
    }

    @Override
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
