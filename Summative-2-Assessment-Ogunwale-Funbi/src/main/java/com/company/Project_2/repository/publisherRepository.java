package com.company.Project_2.repository;

import com.company.Project_2.model.publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface publisherRepository extends JpaRepository<publisher, Integer> {
    List<publisher> findPublisherById(int id);
}
