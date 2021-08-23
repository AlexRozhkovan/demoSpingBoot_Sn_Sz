package com.example.demospingboot_snsz.web;

import com.example.demospingboot_snsz.domain.Person;
import com.example.demospingboot_snsz.domain.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonRestController {
    
    private final PersonRepository repository;
    
    public PersonRestController(PersonRepository repository) {
        this.repository = repository;
    }
    
    //Операция сохранения контактных лиц в базу данных
    @PostMapping("/PERSONS")
    @ResponseStatus(HttpStatus.CREATED)
    public Person savePerson(@RequestBody Person person) {
        
        return repository.save(person);
    }
    
    //Получение списка контактных лиц
    @GetMapping("/PERSONS")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getAllPersons() {
        
        return repository.findAll();
    }
    
    //Получение контактных лиц по id
    @GetMapping("/PERSONS/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person getPersonById(@PathVariable long id) {
        
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Person not found with id = " + id));
    }
    
    //Обновление контактных лиц
    @PutMapping("/PERSONS/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person refreshPerson(@PathVariable("id") long id, @RequestBody Person person) {
        
        return repository.findById(id)
                         .map(entity -> {
                             entity.setName(person.getName());
                             return repository.save(entity);
                         })
                         .orElseThrow(() -> new EntityNotFoundException("Person not found with id = " + id));
    }
    
    /*
    Удаление контактного лица по id
    @DeleteMapping("/PERSONS/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePersonById(@PathVariable long id) {
        repository.findById(id)
                  .map(person -> {
                      person.setDeleted(Boolean.TRUE);
                      return repository.save(person);
                  })
                  .orElseThrow(() -> new EntityNotFoundException("Person not found with id = " + id));
    }*/
    
    /*
    Удаление всех контактных лиц
    @DeleteMapping("/PERSONS")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllPersons() {
        repository.deleteAll();
    }
    */
}