package com.btg.PetSpringApi.controller;

import com.btg.PetSpringApi.controller.dto.OrderRequest;
import com.btg.PetSpringApi.controller.dto.OrderResponse;
import com.btg.PetSpringApi.service.OrderService;
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
        OrderResponse orderResponse = orderService.saveOrder(orderRequest);
        return ResponseEntity.created(URI.create("/order/" + orderResponse.getId())).body(orderResponse);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getOrders(
            @RequestParam(name = "customerId", required = false) Integer customerId,
            @RequestParam(name = "productId", required = false) Integer productId
    ) {
        return ResponseEntity.ok(orderService.getAllOrders(customerId, productId));
    }
}
