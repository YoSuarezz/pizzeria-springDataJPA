package com.pizzeria.pizza.web.controller;

import com.pizzeria.pizza.persistence.entity.PizzaEntity;
import com.pizzeria.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaEntity>> getAll() {
        return ResponseEntity.ok(this.pizzaService.getAll());
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity <PizzaEntity> getById(@PathVariable int idPizza) {
        return ResponseEntity.ok(this.pizzaService.getById(idPizza));
    }

    @GetMapping("name/{name}")
    public ResponseEntity <PizzaEntity> getByName(@PathVariable String name) {
        return ResponseEntity.ok(this.pizzaService.getPizzaByName(name));
    }

    @GetMapping("/available")
    public ResponseEntity <List<PizzaEntity>> getAvailable() {
        return ResponseEntity.ok(this.pizzaService.getAvailable());
    }

    @GetMapping("/with/{ingredient}")
    public ResponseEntity <List<PizzaEntity>> getWith(@PathVariable String ingredient) {
        return ResponseEntity.ok(this.pizzaService.getWith(ingredient));
    }

    @GetMapping("/without/{ingredient}")
    public ResponseEntity <List<PizzaEntity>> getWithout(@PathVariable String ingredient) {
        return ResponseEntity.ok(this.pizzaService.getWithout(ingredient));
    }

    @PostMapping
    public ResponseEntity<PizzaEntity> save(@RequestBody PizzaEntity pizzaEntity) {
        if (pizzaEntity.getIdPizza() == null || !this.pizzaService.existsById(pizzaEntity.getIdPizza())) {
            return ResponseEntity.ok(this.pizzaService.save(pizzaEntity));
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizzaEntity) {
        if (pizzaEntity.getIdPizza() != null && this.pizzaService.existsById(pizzaEntity.getIdPizza())) {
            return ResponseEntity.ok(this.pizzaService.save(pizzaEntity));
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Void> deleteById(@PathVariable int idPizza) {
        if (this.pizzaService.existsById(idPizza)) {
            this.pizzaService.deleteById(idPizza);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

}
