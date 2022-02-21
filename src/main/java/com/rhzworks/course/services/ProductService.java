package com.rhzworks.course.services;

import com.rhzworks.course.entities.Product;
import com.rhzworks.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//a anotation @Service registra o serviço abaixo para ser utilizado em uma injenção de dependencia automatica através do @Autowired
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> object = repository.findById(id);
        return object.get();
    }


}
