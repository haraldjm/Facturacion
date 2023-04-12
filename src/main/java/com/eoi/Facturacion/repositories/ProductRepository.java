package com.eoi.Facturacion.repositories;

import com.eoi.Facturacion.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Creamos el método aquí para que funcione en el ProductService
    //El JpaRepository ya tiene los métodos básicos de CRUD - Implementamos el método findByName
    //JPA nos permite asumer que al crear este método, vamos a crear una QUERY para buscar algo por el nombre de la BBDD


    Optional<Product> findByName(String name);
}
