package br.com.ismadrade.controller;

import br.com.ismadrade.dto.OrderDto;
import br.com.ismadrade.service.OrderService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/orders")
public class OrderController {

    @Inject
    OrderService orderService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderDto> findAllOrders(){
        return orderService.getAllOrders();
    }

    @POST
    @Transactional
    public Response saveOrder(OrderDto orderDto){
        try {
            orderService.saveNewOrder(orderDto);
            return Response.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
