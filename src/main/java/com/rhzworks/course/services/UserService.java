package com.rhzworks.course.services;

import com.rhzworks.course.entities.User;
import com.rhzworks.course.repositories.UserRepository;
import com.rhzworks.course.services.exceptions.ResourceNotFoundException;
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
        return object.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    //findById vai no banco de dados e traz o objeto em questão, enquanto o getById somente prepara o objeto monitorado para ser trabalhado e depois efetuar uma operação com banco de dados (mais eficiente usar desta forma)
    public User update(Long id, User obj){
        User entity = repository.getById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }


}
