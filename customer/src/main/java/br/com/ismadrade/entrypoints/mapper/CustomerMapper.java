package br.com.ismadrade.entrypoints.mapper;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.entrypoints.dto.CustomerDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CustomerMapper {

    CustomerDto of(Customer customer);
    List<CustomerDto> of(List<Customer> products);



}
