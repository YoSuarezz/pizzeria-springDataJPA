package com.pizzeria.pizza.persistence.repository;

import com.pizzeria.pizza.persistence.entity.PizzaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PizzaRepository extends CrudRepository<PizzaEntity, Integer> {
    List<PizzaEntity> findAll();
    PizzaEntity findById(int idPizza);
    PizzaEntity save(PizzaEntity pizzaEntity);
    boolean existsById(int idPizza);
    void deleteById(int idPizza);
}
