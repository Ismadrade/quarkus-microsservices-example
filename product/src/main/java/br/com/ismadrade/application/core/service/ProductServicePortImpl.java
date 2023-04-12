package br.com.ismadrade.application.core.service;

import br.com.ismadrade.adapters.inbound.dto.ProductDto;
import br.com.ismadrade.application.core.domain.Product;
import br.com.ismadrade.application.ports.in.ProductServicePort;
import br.com.ismadrade.application.ports.out.ProductPersistencePort;

import java.util.List;


public class ProductServicePortImpl implements ProductServicePort {

    private final ProductPersistencePort productPersistencePort;

    public ProductServicePortImpl(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public Product create(Product product) {
        return productPersistencePort.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productPersistencePort.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productPersistencePort.findById(id);
    }

    @Override
    public Product changeProduct(Long id, Product product) {
        return productPersistencePort.edit(id, product);
    }

    @Override
    public void deleteProduct(Long id) {
        productPersistencePort.delete(id);
    }
}
