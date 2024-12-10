package com.code.ecommerceharvest.backend.application;

import com.code.ecommerceharvest.backend.domain.model.Order;
import com.code.ecommerceharvest.backend.domain.port.IOrderRepository;
//import org.springframework.stereotype.Service;
//
//@Service

public class OrderService {

    private  final IOrderRepository iOrderRepository;

    public OrderService(IOrderRepository iOrderRepository) {
        this.iOrderRepository = iOrderRepository;
    }

    public Order save (Order  order){
        return this.iOrderRepository.save(order);
    }
    public Iterable<Order> findAll(){
        return this.iOrderRepository.findAll();
    }

    public Iterable<Order> findByUserId(Integer userId){
        return this.iOrderRepository.findByUserId(userId);
    }
    public void updateStateById(Integer id, String state){
        this.iOrderRepository.updateStateById(id, state);
    }

    public Order findById(Integer id){
        return  this.iOrderRepository.findById(id);
    }

}
