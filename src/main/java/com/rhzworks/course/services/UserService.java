package com.rhzworks.course.services;

import com.rhzworks.course.entities.User;
import com.rhzworks.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//a anotation @Service registra o serviço abaixo para ser utilizado em uma injenção de dependencia automatica através do @Autowired
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> object = repository.findById(id);
        return object.get();
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}
