package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface Studentrepo extends CrudRepository<Student, Integer> {
    
}
