package com.example.demo.repository;

import com.example.demo.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<MyOrder, Long>  {

}
