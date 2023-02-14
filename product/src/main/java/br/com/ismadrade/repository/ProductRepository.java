package br.com.ismadrade.repository;

import br.com.ismadrade.entity.ProductEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<ProductEntity> {
}
