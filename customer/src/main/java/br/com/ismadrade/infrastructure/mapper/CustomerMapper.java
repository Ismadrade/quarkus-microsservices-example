package br.com.ismadrade.infrastructure.mapper;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.entrypoints.dto.CustomerDto;
import br.com.ismadrade.infrastructure.jpa.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CustomerMapper {


    Customer of(CustomerEntity customerEntity);
    List<Customer> of(List<CustomerEntity> customerEntity);
    CustomerEntity of(Customer customer);



}
