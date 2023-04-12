package br.com.ismadrade.adapters.outbound.mapper;

import br.com.ismadrade.adapters.outbound.entity.ProductEntity;
import br.com.ismadrade.application.core.domain.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ProductPersistenceMapper {


    ProductEntity of(Product product);
    Product from(ProductEntity entity);
    List<Product> from( List<ProductEntity> entities);

}
