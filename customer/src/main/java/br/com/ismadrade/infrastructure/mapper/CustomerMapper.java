package br.com.ismadrade.infrastructure.mapper;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.domain.vo.Phone;
import br.com.ismadrade.entrypoints.dto.CustomerDto;
import br.com.ismadrade.infrastructure.jpa.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CustomerMapper {


    @Mapping(target = "phone", expression = "java(stringToPhone(customerEntity))")
    Customer of(CustomerEntity customerEntity);

    List<Customer> of(List<CustomerEntity> customerEntity);

    @Mapping(source = "phone", target = "phone", qualifiedByName = "phoneToString")
    CustomerEntity of(Customer customer);


    default String stringToPhone(CustomerEntity customerEntity){
        return customerEntity.getPhone();
    }

    @Named("phoneToString")
    default String phoneToString(Phone phone){
        return phone.getFormattedPhone();
    }



}
