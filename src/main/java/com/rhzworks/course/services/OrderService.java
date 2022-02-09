package com.rhzworks.course.services;

import com.rhzworks.course.entities.Order;
import com.rhzworks.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//a anotation @Service registra o serviço abaixo para ser utilizado em uma injenção de dependencia automatica através do @Autowired
@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> object = repository.findById(id);
        return object.get();
    }


}
