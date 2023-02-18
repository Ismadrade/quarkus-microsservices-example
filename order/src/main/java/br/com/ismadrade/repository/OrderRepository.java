package br.com.ismadrade.repository;

import br.com.ismadrade.entity.OrderEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRepository  implements PanacheRepository<OrderEntity> {
}
