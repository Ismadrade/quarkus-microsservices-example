package br.com.ismadrade.infrastructure.provider;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.port.CustomerPort;
import br.com.ismadrade.infrastructure.entrypoints.dto.CustomerDto;
import br.com.ismadrade.infrastructure.jpa.entity.CustomerEntity;
import br.com.ismadrade.infrastructure.entrypoints.mapper.CustomerMapper;
import br.com.ismadrade.infrastructure.jpa.repository.CustomerRepository;

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
