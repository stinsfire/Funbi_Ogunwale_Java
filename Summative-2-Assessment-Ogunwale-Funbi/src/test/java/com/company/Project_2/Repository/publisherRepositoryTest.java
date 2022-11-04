package com.company.Project_2.Repository;


import com.company.Project_2.model.author;
import com.company.Project_2.model.book;
import com.company.Project_2.model.publisher;
import com.company.Project_2.repository.authorRepository;
import com.company.Project_2.repository.bookRepository;
import com.company.Project_2.repository.publisherRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class publisherRepositoryTest {

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
    public void addGetDeletePublisher() {

        //add Publisher
        publisher test_publisher_1=new publisher();

        test_publisher_1.setName ("OReilly");
        test_publisher_1.setStreet("1266 Frankford Ave");
        test_publisher_1.setCity("Chicago");
        test_publisher_1.setState("IL");
        test_publisher_1.setPostal_code("65414");
        test_publisher_1.setPhone("321-572-9617");
        test_publisher_1.setEmail("oreilly@gmail.com");

        test_publisher_1 = publisher_repo.save(test_publisher_1);


        //find publisher by id
        Optional<publisher> publisher_search = publisher_repo.findById(test_publisher_1.getId());

        assertEquals(publisher_search.get(), test_publisher_1);

        //delete publisher by id
        publisher_repo.deleteById(test_publisher_1.getId());

        publisher_search = publisher_repo.findById(test_publisher_1.getId());

        assertFalse(publisher_search.isPresent());
    }

    // Update publisher test
    @Test
    public void updatePublisher() {

        publisher test_publisher_1=new publisher();

        test_publisher_1.setName ("OReilly");
        test_publisher_1.setStreet("1266 Frankford Ave");
        test_publisher_1.setCity("Chicago");
        test_publisher_1.setState("IL");
        test_publisher_1.setPostal_code("65414");
        test_publisher_1.setPhone("321-572-9617");
        test_publisher_1.setEmail("oreilly@gmail.com");

        test_publisher_1 = publisher_repo.save(test_publisher_1);

        test_publisher_1.setCity("Las Vegas");
        test_publisher_1.setState("NV");
        test_publisher_1.setPostal_code("85627");
        test_publisher_1.setPhone("259-759-4376");

        publisher_repo.save(test_publisher_1);

        Optional<publisher> publisher_search = publisher_repo.findById(test_publisher_1.getId());
        assertEquals(publisher_search.get(), test_publisher_1);
    }


    //get all Publishers
    @Test
    public void getAllPublishers(){
        publisher test_publisher_1=new publisher();

        test_publisher_1.setName ("OReilly");
        test_publisher_1.setStreet("1266 Frankford Ave");
        test_publisher_1.setCity("Chicago");
        test_publisher_1.setState("IL");
        test_publisher_1.setPostal_code("65414");
        test_publisher_1.setPhone("321-572-9617");
        test_publisher_1.setEmail("oreilly@gmail.com");

        test_publisher_1 = publisher_repo.save(test_publisher_1);

        publisher test_publisher_2=new publisher();

        test_publisher_2.setName ("MacMillan");
        test_publisher_2.setStreet("8954 James Str");
        test_publisher_2.setCity("Las Vegas");
        test_publisher_2.setState("NV");
        test_publisher_2.setPostal_code("85627");
        test_publisher_2.setPhone("259-759-4376");
        test_publisher_2.setEmail("mcmlln@gmail.com");

        test_publisher_2 = publisher_repo.save(test_publisher_2);


        publisher test_publisher_3=new publisher();

        test_publisher_3.setName ("Pearson");
        test_publisher_3.setStreet("120 Alexander close");
        test_publisher_3.setCity("Los Angeles");
        test_publisher_3.setState("CA");
        test_publisher_3.setPostal_code("67841");
        test_publisher_3.setPhone("215-894-2637");
        test_publisher_3.setEmail("pearson@gmail.com");

        test_publisher_2 = publisher_repo.save(test_publisher_3);

        List<publisher> PublisherList = publisher_repo.findAll();

        assertEquals(PublisherList.size(), 3);
    }




}
