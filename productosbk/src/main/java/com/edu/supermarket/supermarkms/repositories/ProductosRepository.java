package com.edu.supermarket.supermarkms.repositories;


import com.edu.supermarket.supermarkms.models.Productos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductosRepository extends MongoRepository<Productos,Integer>{

}
