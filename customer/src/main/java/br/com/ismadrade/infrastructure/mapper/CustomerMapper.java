package br.com.ismadrade.infrastructure.mapper;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.infrastructure.dto.CustomerDto;
import br.com.ismadrade.infrastructure.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CustomerMapper {

    CustomerDto toDto(CustomerEntity customer);
    List<CustomerDto> toDtoList(List<CustomerEntity> products);

    CustomerEntity toEntity(CustomerDto dto);

    CustomerEntity of(Customer customer);
}
