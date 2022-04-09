package com.example.CRUDRepository_Homework.services;

import com.example.CRUDRepository_Homework.model.Order;
import com.example.CRUDRepository_Homework.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository ordersRepository;

    public Order getById(Integer id) {
        return ordersRepository.findById(id).get();
    }

    public List<Order> getAllOrders() {
        List<Order> aux = new ArrayList<>();
        ordersRepository.findAll().iterator().forEachRemaining(aux::add);
        return aux;
    }

    public void insert(Order order) {
        ordersRepository.save(order);
    }

    public void updateStatus(Integer id, String status) {
        Order order = ordersRepository.findById(id).get();
        order.setStatus(status);
        ordersRepository.save(order);
    }

    public void delete(Integer id) {
        ordersRepository.delete(ordersRepository.findById(id).get());
    }

    public List<Order> getByCustomerId(Integer id) {
        return ordersRepository.getByCustomerId(id);
    }

}
