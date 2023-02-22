package br.com.ismadrade.infrastructure.jpa.repository;

import br.com.ismadrade.infrastructure.jpa.entity.CustomerEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<CustomerEntity> {
}
