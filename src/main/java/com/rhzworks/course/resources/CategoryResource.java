package com.rhzworks.course.resources;

import com.rhzworks.course.entities.Category;
import com.rhzworks.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//annotation que diz que a classe é um recurso web implementado por um controlador REST
@RestController
//da um nome ao recurso -> o valeu = indica o caminho para o recurso a ser utilizado
@RequestMapping(value="/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    //metodo que é um endpoint para acessar os usuários
    //@getmapping é necessário para indicar que é um metodo que responde a requisição do tipo GET do http
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        //retornar a resposta com sucesso no http  e o .body(u) para retornar no corpo da resposta o usuário u que foi instanciado.
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}