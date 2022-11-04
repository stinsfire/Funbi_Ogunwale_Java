package com.company.Project_2.controller;

import com.company.Project_2.model.author;
import com.company.Project_2.model.book;
import com.company.Project_2.repository.authorRepository;
import com.company.Project_2.repository.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class bookController {

    @Autowired
    bookRepository repo;

    //Get all books
    @GetMapping("/book")
    public List<book> getBooks() {
        return repo.findAll();
    }

    //Get book by id
    @GetMapping("/book/{id}")
    public book getBookById(@PathVariable int id) {

        Optional<book> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }
//    Get book by author_id
    @GetMapping("/book/author_id/{author_id}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<book> getBookByAuthorId(@PathVariable int author_id) {

        List<book> returnVal = repo.findBooksByAuthorId(author_id);
        return repo.findBooksByAuthorId(author_id);
    }

    //Create book
    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public book addBook(@RequestBody book sample_book) {
        return repo.save(sample_book);
    }

    //update book
    @PutMapping("/book")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody book sample_book) {
        repo.save(sample_book);
    }

    //delete book
    @DeleteMapping("/book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        repo.deleteById(id);
    }
}
