package com.example.RestApp.repositories;

import com.example.RestApp.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<Person, Integer> {
    
}
