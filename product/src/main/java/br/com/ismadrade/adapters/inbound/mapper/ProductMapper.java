package br.com.ismadrade.adapters.inbound.mapper;

import br.com.ismadrade.adapters.outbound.entity.ProductEntity;
import br.com.ismadrade.adapters.inbound.dto.ProductDto;
import br.com.ismadrade.application.core.domain.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ProductMapper {

    Product from(ProductDto productDto);
    ProductDto of(Product product);
    List<ProductDto> of(List<Product> products);

}
