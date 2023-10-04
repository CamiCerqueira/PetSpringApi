package com.btg.PetSpringApi.service;

import com.btg.PetSpringApi.controller.dto.OrderRequest;
import com.btg.PetSpringApi.controller.dto.OrderResponse;
import com.btg.PetSpringApi.model.Customer;
import com.btg.PetSpringApi.model.Order;
import com.btg.PetSpringApi.model.Product;
import com.btg.PetSpringApi.repository.ICustomer;
import com.btg.PetSpringApi.repository.IOrder;
import com.btg.PetSpringApi.repository.IProduct;
import com.btg.PetSpringApi.utils.OrderConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //  @Autowired
    // EntityManager entityManager;

    public OrderResponse saveOrder(OrderRequest orderRequest){
        Customer customer = customerRepository.findById(orderRequest.getCustomerId()).get();

        List<Product> products = new ArrayList<>();

        List<Integer> productsId = orderRequest.getProductsIds();

        for(Integer id: productsId){
            Product product = productRepository.findById(id).get();
            products.add(product);
        }

        Order order = OrderConvert.toEntity(orderRequest, customer, products);


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

    public List<OrderResponse> getAllOrders(
            Integer customerId,
            Integer productId){
            //Double minValue,
            //Double masValue){

        if( customerId!= null ) {
            return getAllByCustomer(customerId);
        } else if (productId != null ) {
            return getAllByProduct(productId);
        } else {
            return OrderConvert.toResponseList(orderRepository.findAll());
        }
    }


    //  public Page<OrderResponse> getAllOrders(
    //  Predicate predicate,
    // Pageable pageable
    // ){
    //   Page<Order> orders = orderRepository.findAll(predicate, pageable);

    //  return OrderConvert.toResponsePage(orders);
    //  }

    // public List<OrderResponse> getAllByPrice(Double minValue, Double maxValue){
    //   JPAQuery<Order> query = new JPAQuery<>(entityManager);
    //  QOrder qOrder = QOrder.order;

    //   List<Order> orders = query.from(qOrder).where(qOrder.totalPrice.between(minValue, maxValue)).fetch();
    //   return OrderConvert.toResponseList(orders);
    //  }
}