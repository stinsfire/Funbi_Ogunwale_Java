package com.company.Project_2.controller;


import com.company.Project_2.model.author;
import com.company.Project_2.repository.authorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class authorController {

    @Autowired
    authorRepository repo;

    //Get all authors
    @GetMapping("/author")
    public List<author> getAuthors() {
        return repo.findAll();
    }

    //Get author by id
    @GetMapping("/author/{id}")
    public author getAuthorById(@PathVariable int id) {

        Optional<author> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    //Create author
    @PostMapping("/author")
    @ResponseStatus(HttpStatus.CREATED)
    public author addAuthor(@RequestBody author sample_author) {
        return repo.save(sample_author);
    }

    //update author
    @PutMapping("/author")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(@RequestBody author sample_author) {
        repo.save(sample_author);
    }

    //delete author
    @DeleteMapping("/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) {
        repo.deleteById(id);
    }
}
