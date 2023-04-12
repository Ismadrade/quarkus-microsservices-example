package br.com.ismadrade.application.ports.out;

import br.com.ismadrade.application.core.domain.Product;

import java.util.List;

public interface ProductPersistencePort {
    Product save(Product product);
    Product edit(Long id, Product product);
    Product findById(Long id);
    List<Product> findAll();
    void delete(Long id);

}
