package com.btg.PetSpringApi.utils;

import com.btg.PetSpringApi.controller.dto.OrderRequest;
import com.btg.PetSpringApi.controller.dto.OrderResponse;
import com.btg.PetSpringApi.model.Customer;
import com.btg.PetSpringApi.model.Order;
import com.btg.PetSpringApi.model.PetService;
import com.btg.PetSpringApi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class OrderConvert {

    public static Order toEntity(OrderRequest orderRequest, Customer customer, List<Product> products, List<PetService> petServices){
        Order order = new Order();
        order.setTotalPrice(orderRequest.getTotalPrice());
        order.setCustomerId(customer);
        order.setProducts(products);
        order.setPetServices(petServices);
        return order;
    }


    public static OrderResponse toResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setCustomer(order.getCustomerId());
        orderResponse.setProductId(order.getProducts());
        orderResponse.setPetServiceId(order.getPetServices());
        orderResponse.setTotalPrice(order.getTotalPrice());

        return orderResponse;
    }
    public static List<OrderResponse> toResponseList(List<Order> orders) {
        List<OrderResponse> orderResponse = new ArrayList<>();
        for (Order order : orders) {
            orderResponse.add(toResponse(order));
        }

        return orderResponse;
    }

    public static Page<OrderResponse> toResponsePage(Page<Order> orders) {
        List<OrderResponse> orderResponses = new ArrayList<>();
        for (Order order : orders) {
            OrderResponse orderResponse = OrderConvert.toResponse(order);
            orderResponses.add(orderResponse);
        }
        return new PageImpl<>(orderResponses);
    }
}