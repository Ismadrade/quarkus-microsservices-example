package br.com.ismadrade.infrastructure.repository;

import br.com.ismadrade.infrastructure.entity.CustomerEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<CustomerEntity> {
}
