package com.example.demospingboot_snsz.web;

import com.example.demospingboot_snsz.domain.Supplier;
import com.example.demospingboot_snsz.domain.SupplierRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeRestController {

    private final SupplierRepository repository;

    public EmployeeRestController(SupplierRepository repository) {
        this.repository = repository;
    }
    
    //Операция сохранения юзера в базу данных
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Supplier saveEmployee(@RequestBody Supplier supplier) {

        return repository.save(supplier);
    }

    //Получение списка юзеров
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<Supplier> getAllUsers() {

        return repository.findAll();
    }

    //Получения юзера по id
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Supplier getEmployeeById(@PathVariable long id) {

        Supplier supplier = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id = " + id));

        if (supplier.getIsDeleted()) {
            throw new EntityNotFoundException("Supplier was deleted with id = " + id);
        }

        return supplier;
    }

    //Обновление юзера
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Supplier refreshEmployee(@PathVariable("id") long id, @RequestBody Supplier supplier) {

        return repository.findById(id)
                .map(entity -> {
                    entity.setName(supplier.getName());
                    return repository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id = " + id));
    }

    //Удаление по id
    //@DeleteMapping("/users/{id}")
    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployeeById(@PathVariable long id) {
        repository.findById(id)
                .map(supplier -> {
                    supplier.setIsDeleted(Boolean.TRUE);
                    return repository.save(supplier);
                })
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id = " + id));
    }

    //Удаление всех юзеров
    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllUsers() {
        repository.deleteAll();
    }
}
