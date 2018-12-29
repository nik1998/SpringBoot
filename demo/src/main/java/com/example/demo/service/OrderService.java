package com.example.demo.service;

import com.example.demo.MyOrder;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class OrderService {

    @Autowired
    private final OrderRepository rep;
    public OrderService(OrderRepository rep){
        this.rep = rep;
    }

    @Transactional
    public void createOrder(MyOrder orders) {

        rep.save(orders);
    }
    @Transactional
    public void updateOrder(MyOrder orders)
    {
        try
        {
            rep.deleteById(orders.getId());
        }
        catch(Exception ex)
        {

        }
        rep.save(orders);
    }
    @Transactional
    public void deleteOrder(Long id) {

        rep.deleteById(id);
    }
    public List<MyOrder> findAll(){

        return rep.findAll();
    }


}