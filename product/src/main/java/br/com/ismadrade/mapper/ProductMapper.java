package br.com.ismadrade.mapper;

import br.com.ismadrade.dto.ProductDto;
import br.com.ismadrade.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ProductMapper {

    ProductDto toDto(ProductEntity product);
    List<ProductDto> toDtoList(List<ProductEntity> products);

    ProductEntity toEntity(ProductDto dto);

}
