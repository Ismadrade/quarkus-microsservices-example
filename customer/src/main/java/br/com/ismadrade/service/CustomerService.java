package br.com.ismadrade.service;

import br.com.ismadrade.dto.CustomerDto;
import br.com.ismadrade.entity.CustomerEntity;
import br.com.ismadrade.mapper.CustomerMapper;
import br.com.ismadrade.repository.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerService {

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

    public void createNewCustomer(CustomerDto customerDto){
        customerRepository.persist(customerMapper.toEntity(customerDto));
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
