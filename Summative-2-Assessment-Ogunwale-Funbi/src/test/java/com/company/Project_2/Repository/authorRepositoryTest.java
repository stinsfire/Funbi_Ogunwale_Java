package com.company.Project_2.Repository;


import com.company.Project_2.model.author;
import com.company.Project_2.model.book;
import com.company.Project_2.repository.authorRepository;
import com.company.Project_2.repository.bookRepository;
import com.company.Project_2.repository.publisherRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class authorRepositoryTest {

    @Autowired
    bookRepository book_repo;

    @Autowired
    authorRepository author_repo;

    @Autowired
    publisherRepository publisher_repo;

    @Before
    public void setUp() throws Exception {

        book_repo.deleteAll();
        author_repo.deleteAll();
        publisher_repo.deleteAll();
    }

    @Test
    public void contextLoads() {
    }


    @Test
    public void addGetDeleteAuthor() {

        //add author
        author test_author_1 = new author();

        test_author_1.setFirst_name("James");
        test_author_1.setLast_name("Vida");
        test_author_1.setStreet("1785 North Boston");
        test_author_1.setCity("Baltimore");
        test_author_1.setState("MD");
        test_author_1.setPostal_code("54687");
        test_author_1.setPhone("589-784-8957");
        test_author_1.setEmail("jvida@gmail.com");


        test_author_1 = author_repo.save(test_author_1);

        //find author
        Optional<author> author_search = author_repo.findById(test_author_1.getId());

        assertEquals(author_search.get(), test_author_1);

        //delete author
        author_repo.deleteById(test_author_1.getId());

        author_search = author_repo.findById(test_author_1.getId());

        assertFalse(author_search.isPresent());
    }

    //update author
    @Test
    public void updateAuthor(){
        author test_author_1 = new author();

        test_author_1.setFirst_name("James");
        test_author_1.setLast_name("Vida");
        test_author_1.setStreet("1785 North Boston");
        test_author_1.setCity("Baltimore");
        test_author_1.setState("MD");
        test_author_1.setPostal_code("54687");
        test_author_1.setPhone("589-784-8957");
        test_author_1.setEmail("jvida@gmail.com");

        test_author_1 = author_repo.save(test_author_1);

        test_author_1.setLast_name("Spader");
        test_author_1.setCity("Seattle");
        test_author_1.setState("WA");

        author_repo.save(test_author_1);

        Optional<author> author_search = author_repo.findById(test_author_1.getId());
        assertEquals(author_search.get(), test_author_1);
    }


    //get all authors
    @Test
    public void getAllAuthors() {
        author test_author_1 = new author();

        test_author_1.setFirst_name("James");
        test_author_1.setLast_name("Vida");
        test_author_1.setStreet("1785 North Boston");
        test_author_1.setCity("Baltimore");
        test_author_1.setState("MD");
        test_author_1.setPostal_code("54687");
        test_author_1.setPhone("589-784-8957");
        test_author_1.setEmail("jvida@gmail.com");


        test_author_1 = author_repo.save(test_author_1);

        author test_author_2 = new author();

        test_author_2.setFirst_name("Shawn");
        test_author_2.setLast_name("Carter");
        test_author_2.setStreet("1274 brooklyn lane");
        test_author_2.setCity("Los Angeles");
        test_author_2.setState("CA");
        test_author_2.setPostal_code("35641");
        test_author_2.setPhone("647-342-3467");
        test_author_2.setEmail("scarter@gmail.com");


        test_author_2 = author_repo.save(test_author_2);

        List<author> authorList = author_repo.findAll();
        assertEquals(authorList.size(), 2);
    }


}
