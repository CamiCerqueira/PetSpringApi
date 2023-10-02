package com.btg.PetSpringApi.controller;

import com.btg.PetSpringApi.controller.dto.OrderRequest;
import com.btg.PetSpringApi.controller.dto.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> saveOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse orderReponse = orderService.saveOrder(orderRequest);
        return ResponseEntity.created(URI.create("/order/" + orderReponse.getId())).body(orderReponse);
    }


    @GetMapping
    public ResponseEntity<List<OrderResponse>> getOrder((
       @RequestParam(name = "userId", required = false) Integer userId,
       @RequestParam(name = "productId", required = false) Integer productId
    ){
        return ResponseEntity.ok(orderService.getAllOrders(userId, productId));
    }

}
