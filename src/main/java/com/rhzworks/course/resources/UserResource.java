package com.rhzworks.course.resources;

import com.rhzworks.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//annotation que diz que a classe é um recurso web implementado por um controlador REST
@RestController
//da um nome ao recurso -> o valeu = indica o caminho para o recurso a ser utilizado
@RequestMapping(value="/users")
public class UserResource {

    //metodo que é um endpoint para acessar os usuários
    //@getmapping é necessário para indicar que é um metodo que responde a requisição do tipo GET do http
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Maria", "maria@gmail.com", "999999999", "123456");
        //retornar a resposta com sucesso no http  e o .body(u) para retornar no corpo da resposta o usuário u que foi instanciado.
        return ResponseEntity.ok().body(u);
    }
}
