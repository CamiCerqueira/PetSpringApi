package com.btg.PetSpringApi.service;

import com.btg.PetSpringApi.controller.dto.OrderRequest;
import com.btg.PetSpringApi.controller.dto.OrderResponse;
import com.btg.PetSpringApi.model.*;
import com.btg.PetSpringApi.model.PetService;
import com.btg.PetSpringApi.repository.ICustomer;
import com.btg.PetSpringApi.repository.IOrder;
import com.btg.PetSpringApi.repository.IProduct;
import com.btg.PetSpringApi.utils.OrderConvert;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;



@Service
public class OrderService {

    @Autowired
    IOrder orderRepository;

    @Autowired
    ICustomer customerRepository;

    @Autowired
    IProduct productRepository;

      @Autowired
      EntityManager entityManager;

    public OrderResponse saveOrder(OrderRequest orderRequest){
        Customer customer = customerRepository.findById(orderRequest.getCustomerId()).get();

        List<Product> products = new ArrayList<>();

        List<Product> productsIds = orderRequest.getProducts();
        List<PetService> petService = orderRequest.getPetServices();

        for(Product product: products){
            Product getproduct = productRepository.findById(product.getId()).get();
            products.add(getproduct);
        }


        Order order = OrderConvert.toEntity(orderRequest, customer, products, petService);


        return OrderConvert.toResponse(orderRepository.save(order));
    }

   // public List<OrderResponse> getAllByPrice(double minPrice, double maxPrice) {
     //   List<Order> orders = orderRepository.findAllByPrice(minPrice, maxPrice);
      //  return OrderConvert.toResponseList(orders);
    //}


    public List<OrderResponse> getAllByCustomer(Integer customerId){
        return OrderConvert.toResponseList(orderRepository.findAllByCustomer(customerId));
    }

    public List<OrderResponse> getAllByProduct(Integer productId){
        return OrderConvert.toResponseList(orderRepository.findAllByProduct(productId));
    }

    public Page<OrderResponse> getAllOrders(
           Predicate predicate,
           Pageable pageable
            ){

       Page<Order> orders = orderRepository.findAll(predicate, pageable);

      return OrderConvert.toResponsePage(orders);
      }

    public List<OrderResponse> getAllByPrice(Double minValue, Double maxValue){
       JPAQuery<Order> query = new JPAQuery<>(entityManager);
       QOrder qOrder = QOrder.order;

       List<Order> orders = query.from(qOrder).where(qOrder.totalPrice.between(minValue, maxValue)).fetch();
       return OrderConvert.toResponseList(orders);
      }
}