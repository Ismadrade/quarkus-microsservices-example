package br.com.ismadrade.mapper;

import br.com.ismadrade.dto.CustomerDto;
import br.com.ismadrade.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CustomerMapper {

    CustomerDto toDto(CustomerEntity customer);
    List<CustomerDto> toDtoList(List<CustomerEntity> products);

    CustomerEntity toEntity(CustomerDto dto);
}
