package com.company.Project_2.repository;

import com.company.Project_2.model.author;
import com.company.Project_2.model.book;
import com.company.Project_2.model.publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bookRepository extends JpaRepository<book, Integer> {
    List<book> findBookById(int id);
    List<book> findBooksByAuthorId (int id);
}
