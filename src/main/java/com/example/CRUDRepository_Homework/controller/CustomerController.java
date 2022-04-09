package com.example.CRUDRepository_Homework.controller;

import com.example.CRUDRepository_Homework.model.Customer;
import com.example.CRUDRepository_Homework.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getById(@PathVariable Integer id)
    {
        return customerService.getById(id);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customers){
        customerService.insert(customers);
        return customers;
    }
    @PostMapping("/customers/update")
    public Customer updateCustomer(@RequestBody Customer customers){
        customerService.update(customers);
        return customers;
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@RequestBody Customer customers){
        customerService.delete(customers);
    }


    public Customer register(String username,String password){
        Customer customer=new Customer();

       Scanner in = new Scanner(System.in);
        String first_name= in.nextLine();
        String last_name=in.nextLine();
        String address=in.nextLine();
        String postalCode=in.nextLine();
        String phone=in.nextLine();

        customer.setUsername(username);
        customer.setPassword(password);
        customer.setFirst_name(first_name);
        customer.setLast_name(last_name);
        customer.setAddress(address);
        customer.setPostalCode(postalCode);
        customer.setPhone(phone);
        return customer;
    }

    @PostMapping("/createcookie")
    public ResponseEntity login(String username, String password){
        if(register("user","pass")!=null){
            if(register("user","pass").getUsername().compareTo(username)!=0){
                System.out.println("user corect!");
            }
            else System.out.println("user gresit!");
        }else {
            System.out.println("nu a fost creat un astfel de user!");
        }


       ResponseCookie springCookie =ResponseCookie.from("user", "1")
                       .httpOnly(true)
                       .secure(true)
                       .path("/")
                       .maxAge(60)
                       .domain("localhost:8080")
                       .build();
        return ResponseEntity
                        .ok()
                        .header(HttpHeaders.SET_COOKIE,springCookie.toString())
                        .build();
   }

    @GetMapping("/cookie")
    public String readCookie(@CookieValue(name = "user",defaultValue = "default")String userId) {
        return userId;
    }

    @DeleteMapping("/deletecookie")
    public void deleteCookie(){
        ResponseCookie deleteSpringCookie = ResponseCookie.from("user", null)
                                .maxAge(0)
                                .build();
        ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE,deleteSpringCookie.toString())
                .build();
    }
}
