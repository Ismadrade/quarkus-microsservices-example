package br.com.ismadrade.infrastructure.service;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.gateway.CustomerGateway;
import br.com.ismadrade.infrastructure.dto.CustomerDto;
import br.com.ismadrade.infrastructure.entity.CustomerEntity;
import br.com.ismadrade.infrastructure.mapper.CustomerMapper;
import br.com.ismadrade.infrastructure.repository.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerService implements CustomerGateway {

    @Inject
    CustomerRepository customerRepository;

    @Inject
    CustomerMapper customerMapper;

    public List<CustomerDto> findAllCustomers(){
        return customerMapper.toDtoList(customerRepository
                .findAll()
                .stream()
                .collect(Collectors.toList()));
    }

    public CustomerDto findCustomerById(Long id) {
        return customerMapper.toDto(customerRepository.findById(id));
    }

    public Customer createNewCustomer(final  Customer customer){
        customerRepository.persist(customerMapper.of(customer));
        return customer;
    }

    public void changeCustomer(Long id, CustomerDto customerDto){
        CustomerEntity customer = customerRepository.findById(id);

        customer.setName(customerDto.getName());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        customer.setAddress(customerDto.getAddress());
        customer.setAge(customerDto.getAge());

        customerRepository.persist(customer);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
