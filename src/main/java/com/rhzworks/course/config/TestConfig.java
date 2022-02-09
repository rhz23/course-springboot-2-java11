package com.rhzworks.course.config;

import com.rhzworks.course.entities.Category;
import com.rhzworks.course.entities.Order;
import com.rhzworks.course.entities.User;
import com.rhzworks.course.entities.enums.OrderStatus;
import com.rhzworks.course.repositories.CategoryRepository;
import com.rhzworks.course.repositories.OrderRepository;
import com.rhzworks.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//a anotation abaixo indica que a classe é uma classe de configuração
@Configuration
//a anotation abaixo indica o profile que utilizará essa configuração, neste caso o profile de "test", o nome tem que ser igual ao nome utilizado na application.properties do profile especifico (neste caso do application-test.properties)
@Profile("test")
public class TestConfig implements CommandLineRunner {

    //o comando abaixo utiliza recursos do springboot para resolver essa dependencia e associar uma instancia de userRepository
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    //o método abaixo é um método a ser implementado da intarface CommandLineRunner onde tudo que for adicionado no corpo o mesmo sera executado na execução do programa.
    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);



        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
