package br.com.ismadrade.mapper;

import br.com.ismadrade.dto.OrderDto;
import br.com.ismadrade.entity.OrderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface OrderMapper {

    OrderDto toDto(OrderEntity customer);
    List<OrderDto> toDtoList(List<OrderEntity> products);

    OrderEntity toEntity(OrderDto dto);
}
