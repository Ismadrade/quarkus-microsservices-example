package br.com.ismadrade.adapters.outbound;

import br.com.ismadrade.adapters.inbound.dto.ProductDto;
import br.com.ismadrade.adapters.outbound.entity.ProductEntity;
import br.com.ismadrade.adapters.inbound.mapper.ProductMapper;
import br.com.ismadrade.adapters.outbound.mapper.ProductPersistenceMapper;
import br.com.ismadrade.adapters.outbound.repository.ProductRepository;
import br.com.ismadrade.application.core.domain.Product;
import br.com.ismadrade.application.ports.out.ProductPersistencePort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductPersistencePortImpl implements ProductPersistencePort {

    @Inject
    ProductRepository productRepository;

    @Inject
    ProductPersistenceMapper productPersistenceMapper;

    @Override
    public List<Product> findAll(){
        return productPersistenceMapper.from(productRepository
                .findAll()
                .stream()
                .collect(Collectors.toList()));
    }

    @Override
    public Product save(Product product){
        productRepository.persist(productPersistenceMapper.of(product));
        return product;
    }

    @Override
    public Product edit(Long id, Product product){
        ProductEntity productEntity = productRepository.findById(id);

        productEntity.setName(product.getName());
        productEntity.setCategory(product.getCategory());
        productEntity.setModel(product.getModel());
        productEntity.setDescription(product.getDescription());
        productEntity.setPrice(product.getPrice());

        productRepository.persist(productEntity);
        return product;
    }

    @Override
    public void delete(Long id){
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        return productPersistenceMapper.from(productRepository.findById(id));
    }
}
