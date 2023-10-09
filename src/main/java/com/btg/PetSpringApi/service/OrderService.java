package com.btg.PetSpringApi.service;

import com.btg.PetSpringApi.controller.dto.OrderRequest;
import com.btg.PetSpringApi.controller.dto.OrderResponse;
import com.btg.PetSpringApi.model.*;
import com.btg.PetSpringApi.model.PetService;
import com.btg.PetSpringApi.repository.ICustomer;
import com.btg.PetSpringApi.repository.IOrder;
import com.btg.PetSpringApi.repository.IPetService;
import com.btg.PetSpringApi.repository.IProduct;
import com.btg.PetSpringApi.utils.OrderConvert;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class OrderService {

    @Autowired
    IOrder orderRepository;

    @Autowired
    ICustomer customerRepository;

    @Autowired
    IProduct productRepository;

    @Autowired
    IPetService petServiceRepository;

    @Autowired
    EntityManager entityManager;

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        Customer customer = customerRepository.findById(order.getCustomerId().getId()).orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));

        order.setCustomerId(customer);

        return orderRepository.save(order);
    }

//    public OrderResponse saveOrder(OrderRequest orderRequest) {
//        Customer customer = customerRepository.findById(orderRequest.getCustomerId()).get();
//
//        List<Product> products = new ArrayList<>();
//        List<Integer> productsId = orderRequest.getProductId();
//        for (Integer id : productsId) {
//            Product product = productRepository.findById(id).get();
//        }
//
//        List<PetService> petServices = new ArrayList<>();
//        List<Integer> petServicesId = orderRequest.getPetServicesId();
//        for (Integer id : petServicesId){
//            PetService petService = petServiceRepository.findById(id).get();
//
//        }
//
//        Order order = OrderConvert.toEntity(orderRequest, customer, products, petServices);
//        return OrderConvert.toResponse(orderRepository.save(order));
//    }
    public Order saveOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setTotalPrice(orderRequest.getTotalPrice());
        Customer customer = customerRepository.findById(orderRequest.getCustomerId()).orElseThrow(() ->
                new NoSuchElementException("Cliente não encontrado"));order.setCustomerId(customer);

        List<Product> products = productRepository.findAllById(orderRequest.getProductId());
        order.setProducts(products);

        List<PetService> petServices = petServiceRepository.findAllById(orderRequest.getPetServicesId());
        order.setPetServices(petServices);

        return orderRepository.save(order);
    }
    public List<OrderResponse> getAllByCustomer(Integer customerId) {
            return OrderConvert.toResponseList(orderRepository.findAllByCustomer(customerId));
    }

    public Page<OrderResponse> getAllOrders(
            Predicate predicate,
            Pageable pageable
    ) {

        Page<Order> orders = orderRepository.findAll(predicate, pageable);

        return OrderConvert.toResponsePage(orders);
    }

    public List<OrderResponse> getAllByPrice(Double minValue, Double maxValue) {
        JPAQuery<Order> query = new JPAQuery<>(entityManager);
        QOrder qOrder = QOrder.order;

        List<Order> orders = query.from(qOrder).where(qOrder.totalPrice.between(minValue, maxValue)).fetch();
        return OrderConvert.toResponseList(orders);
    }

}