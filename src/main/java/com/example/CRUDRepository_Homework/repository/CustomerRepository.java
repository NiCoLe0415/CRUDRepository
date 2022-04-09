package com.example.CRUDRepository_Homework.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CRUDRepository_Homework.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public Customer getById(Integer id);
}
