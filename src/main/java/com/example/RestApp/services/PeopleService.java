package com.example.RestApp.services;

import com.example.RestApp.models.Person;
import com.example.RestApp.repositories.PeopleRepository;
import com.example.RestApp.util.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;
    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {

        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAllPeople() {

        return peopleRepository.findAll();
    }

    public Person findPersonById(int id) {
        Optional<Person> person = peopleRepository.findById(id);
        return person.orElseThrow(PersonNotFoundException::new);
    }

    @Transactional
    public void savePerson(Person person){
         addToPerson(person);

        peopleRepository.save(person);
    }

    private void addToPerson(Person person) {
        person.setCreatedAt(LocalDateTime.now());
        person.setUpdatedAt(LocalDateTime.now());
        person.setCreatedWho("ADMIN");
    }

}
