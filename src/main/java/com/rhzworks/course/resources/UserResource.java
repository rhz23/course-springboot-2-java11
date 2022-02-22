package com.rhzworks.course.resources;

import com.rhzworks.course.entities.User;
import com.rhzworks.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//annotation que diz que a classe é um recurso web implementado por um controlador REST
@RestController
//da um nome ao recurso -> o valeu = indica o caminho para o recurso a ser utilizado
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService service;

    //metodo que é um endpoint para acessar os usuários
    //@getmapping é necessário para indicar que é um metodo que responde a requisição do tipo GET do http
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        //User u = new User(1L, "Maria", "maria@gmail.com", "999999999", "123456");
        List<User> list = service.findAll();
        //retornar a resposta com sucesso no http  e o .body(u) para retornar no corpo da resposta o usuário u que foi instanciado.
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
