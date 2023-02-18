package br.com.ismadrade.service;

import br.com.ismadrade.client.CustomerClient;
import br.com.ismadrade.client.ProductClient;
import br.com.ismadrade.dto.CustomerDto;
import br.com.ismadrade.dto.OrderDto;
import br.com.ismadrade.mapper.OrderMapper;
import br.com.ismadrade.repository.OrderRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class OrderService {

    @Inject
    OrderRepository orderRepository;

    @Inject
    @RestClient
    CustomerClient customerClient;

    @Inject
    @RestClient
    ProductClient productClient;

    @Inject
    OrderMapper orderMapper;


    public List<OrderDto> getAllOrders() {
        return orderMapper.toDtoList(orderRepository
                .findAll()
                .stream()
                .collect(Collectors.toList()));
    }

    public void saveNewOrder (OrderDto orderDto) {
        CustomerDto customerDTO = customerClient.getCustomerById(orderDto.getCustomerId());
        if (customerDTO.getName().equals(orderDto.getCustomerName())
                && productClient.getProductById(orderDto.getProductId()) != null) {
            orderRepository.persist(orderMapper.toEntity(orderDto));

        } else {
            throw new NotFoundException();
        }
    }





}
