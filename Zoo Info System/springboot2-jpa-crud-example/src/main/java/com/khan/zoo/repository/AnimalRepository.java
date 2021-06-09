package com.khan.zoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khan.zoo.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{

}
