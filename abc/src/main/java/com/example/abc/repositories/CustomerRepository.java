package com.example.abc.repositories;

import com.example.abc.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
    //@Override
    //Optional<Customer> findById(Integer integer);

//    @Override
//    List<Customer> findAll();

}
