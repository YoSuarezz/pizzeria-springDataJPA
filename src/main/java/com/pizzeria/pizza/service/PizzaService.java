package com.pizzeria.pizza.service;

import com.pizzeria.pizza.persistence.entity.PizzaEntity;
import com.pizzeria.pizza.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaEntity> getAll(){
        return this.pizzaRepository.findAll();
    }

    public PizzaEntity getById(int idPizza){
        return this.pizzaRepository.findById(idPizza);
    }

    public PizzaEntity save(PizzaEntity pizzaEntity){
        return this.pizzaRepository.save(pizzaEntity);
    }
    public boolean existsById(int idPizza){
        return this.pizzaRepository.existsById(idPizza);
    }
}
