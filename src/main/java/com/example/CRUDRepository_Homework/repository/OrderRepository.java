package com.example.CRUDRepository_Homework.repository;

import com.example.CRUDRepository_Homework.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    public List<Order> getByCustomerId(Integer Id);
    public List<Order> getAllByCustomerId(Integer id);
}