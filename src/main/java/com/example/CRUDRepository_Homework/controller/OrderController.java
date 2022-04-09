package com.example.CRUDRepository_Homework.controller;

import com.example.CRUDRepository_Homework.model.Order;
import com.example.CRUDRepository_Homework.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService ordersService;

    @GetMapping("/orders/{id}")
    public Order getById(@PathVariable Integer id){
        return ordersService.getById(id);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return ordersService.getAllOrders();
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order){
        ordersService.insert(order);
        return order;
    }

    @PostMapping("/orders/{id}/{status}/updateStatus")
    public void updateOrder(@PathVariable Integer id,@PathVariable String status){
        ordersService.updateStatus(id,status);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Integer id){
        ordersService.delete(id);
    }

    @GetMapping("/orders/{id}/getByCustomerId")
    public List<Order> customerOrders(@PathVariable Integer id){
        return ordersService.getByCustomerId(id);
    }

}
