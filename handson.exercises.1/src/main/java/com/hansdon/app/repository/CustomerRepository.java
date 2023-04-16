package com.hansdon.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hansdon.app.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
