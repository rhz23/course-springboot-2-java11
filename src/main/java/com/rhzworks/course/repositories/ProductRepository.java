package com.rhzworks.course.repositories;

import com.rhzworks.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//opcional colocar o @Repository porque a UserRepository já esta herdando do JpaRepository que é uma classe registrada no Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
