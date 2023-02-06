package br.com.ismadrade.service;

import br.com.ismadrade.dto.CustomerDto;
import br.com.ismadrade.entity.CustomerEntity;
import br.com.ismadrade.repository.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;

    public List<CustomerDto> findAllCustomers(){
        return customerRepository
                .findAll()
                .stream()
                .map((this::mapCustomerEntityToDTO))
                .collect(Collectors.toList());
    }

    public void createNewCustomer(CustomerDto customerDto){
        customerRepository.persist(mapCustomerDTOToEntity(customerDto));
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

    private CustomerDto mapCustomerEntityToDTO(CustomerEntity customer){

        return new CustomerDto(customer.getName(),
                customer.getPhone(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getAge()
        );
    }

    private CustomerEntity mapCustomerDTOToEntity(CustomerDto customerDto){

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setName(customerDto.getName());
        customerEntity.setPhone(customerDto.getPhone());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setAddress(customerDto.getAddress());
        customerEntity.setAge(customerDto.getAge());

        return customerEntity;
    }

}
