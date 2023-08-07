package com.examly.springapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.Springapp;  
@Repository
public interface SpringappRepository extends JpaRepository<Springapp,Integer> {
    
}
