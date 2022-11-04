package com.company.Project_2.controller;

import com.company.Project_2.model.author;
import com.company.Project_2.model.publisher;
import com.company.Project_2.repository.authorRepository;
import com.company.Project_2.repository.publisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class publisherController {
    @Autowired
    publisherRepository repo;

    //Get all publishers
    @GetMapping("/publisher")
    public List<publisher> getPublishers() {
        return repo.findAll();
    }

    //Get publisher by id
    @GetMapping("/publisher/{id}")
    public publisher getPublisherById(@PathVariable int id) {

        Optional<publisher> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    //Create publisher
    @PostMapping("/publisher")
    @ResponseStatus(HttpStatus.CREATED)
    public publisher addPublisher(@RequestBody publisher sample_publisher) {
        return repo.save(sample_publisher);
    }

    //update publisher
    @PutMapping("/publisher")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody publisher sample_publisher) {
        repo.save(sample_publisher);
    }

    //delete publisher
    @DeleteMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id) {
        repo.deleteById(id);
    }
}
