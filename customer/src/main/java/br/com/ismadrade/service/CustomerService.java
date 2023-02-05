package br.com.ismadrade.service;

import br.com.ismadrade.dto.CustomerDto;
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
        return customerRepository.findAll().stream().map(CustomerDto::new).collect(Collectors.toList());
    }

    public void create

}
