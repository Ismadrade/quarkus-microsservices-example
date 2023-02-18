package br.com.ismadrade.service;

import br.com.ismadrade.dto.ProductDto;
import br.com.ismadrade.entity.ProductEntity;
import br.com.ismadrade.mapper.ProductMapper;
import br.com.ismadrade.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    @Inject
    ProductMapper productMapper;

    public List<ProductDto> getAllProducts(){
        return productMapper.toDtoList(productRepository
                .findAll()
                .stream()
                .collect(Collectors.toList()));
    }

    public void createNewProduct(ProductDto productDto){
        productRepository.persist(productMapper.toEntity(productDto));
    }

    public void changeProduct(Long id, ProductDto productDto){
        ProductEntity productEntity = productRepository.findById(id);

        productEntity.setName(productDto.getName());
        productEntity.setCategory(productDto.getCategory());
        productEntity.setModel(productDto.getModel());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setPrice(productDto.getPrice());

        productRepository.persist(productEntity);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public ProductDto findProductById(Long id) {
        return productMapper.toDto(productRepository.findById(id));
    }
}
