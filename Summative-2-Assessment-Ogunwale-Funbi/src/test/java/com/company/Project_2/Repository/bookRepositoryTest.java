
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
public class bookRepositoryTest {
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

    //Add book test
    @Test
    public void addGetDeleteBook() {

        //add book test
        author test_author_1=new author();

        test_author_1.setFirst_name("James");
        test_author_1.setLast_name("Vida");
        test_author_1.setStreet("1785 North Boston");
        test_author_1.setCity("Baltimore");
        test_author_1.setState("MD");
        test_author_1.setPostal_code("54687");
        test_author_1.setPhone("589-784-8957");
        test_author_1.setEmail("jvida@gmail.com");

        test_author_1 = author_repo.save(test_author_1);


        publisher test_publisher_1=new publisher();

        test_publisher_1.setName ("OReilly");
        test_publisher_1.setStreet("1266 Frankford Ave");
        test_publisher_1.setCity("Chicago");
        test_publisher_1.setState("IL");
        test_publisher_1.setPostal_code("65414");
        test_publisher_1.setPhone("321-572-9617");
        test_publisher_1.setEmail("oreilly@gmail.com");

        test_publisher_1 = publisher_repo.save(test_publisher_1);

        book test_book = new book();

        test_book.setIsbn("1-01-502772-5");
        test_book.setPublish_date("2020-12-06");
        test_book.setAuthorId(test_author_1.getId());
        test_book.setTitle("Big data Analytics");
        test_book.setPublisherId(test_publisher_1.getId());
        test_book.setPrice(BigDecimal.valueOf(23.78));

        test_book = book_repo.save(test_book);

        //find book by id
        Optional<book> book_search = book_repo.findById(test_book.getId());

        assertEquals(book_search.get(), test_book);

        //delete book by id
        book_repo.deleteById(test_book.getId());

        book_search = book_repo.findById(test_book.getId());

        assertFalse(book_search.isPresent());
    }

    // Update book test
    @Test
    public void updateBook() {

        author test_author_1=new author();

        test_author_1.setFirst_name("James");
        test_author_1.setLast_name("Vida");
        test_author_1.setStreet("1785 North Boston");
        test_author_1.setCity("Baltimore");
        test_author_1.setState("MD");
        test_author_1.setPostal_code("54687");
        test_author_1.setPhone("589-784-8957");
        test_author_1.setEmail("jvida@gmail.com");

        test_author_1 = author_repo.save(test_author_1);


        publisher test_publisher_1=new publisher();

        test_publisher_1.setName ("OReilly");
        test_publisher_1.setStreet("1266 Frankford Ave");
        test_publisher_1.setCity("Chicago");
        test_publisher_1.setState("IL");
        test_publisher_1.setPostal_code("65414");
        test_publisher_1.setPhone("321-572-9617");
        test_publisher_1.setEmail("oreilly@gmail.com");

        test_publisher_1 = publisher_repo.save(test_publisher_1);

        book test_book = new book();

        test_book.setIsbn("1-01-502772-5");
        test_book.setPublish_date("2020-12-06");
        test_book.setAuthorId(test_author_1.getId());
        test_book.setTitle("Big data Analytics");
        test_book.setPublisherId(test_publisher_1.getId());
        test_book.setPrice(BigDecimal.valueOf(23.78));

        test_book = book_repo.save(test_book);

        test_book.setPublish_date("2019-08-15");
        test_book.setTitle("Advanced Computing");
        test_book.setTitle("Unsupervised Learning");

        book_repo.save(test_book);

        Optional<book> book_search = book_repo.findById(test_book.getId());
        assertEquals(book_search.get(), test_book);
    }

//    find Books by author test
    @Test
    public void getBooksByAuthorId() {

        author test_author_1=new author();

        test_author_1.setFirst_name("James");
        test_author_1.setLast_name("Vida");
        test_author_1.setStreet("1785 North Boston");
        test_author_1.setCity("Baltimore");
        test_author_1.setState("MD");
        test_author_1.setPostal_code("54687");
        test_author_1.setPhone("589-784-8957");
        test_author_1.setEmail("jvida@gmail.com");

        test_author_1 = author_repo.save(test_author_1);

        publisher test_publisher_1=new publisher();

        test_publisher_1.setName ("OReilly");
        test_publisher_1.setStreet("1266 Frankford Ave");
        test_publisher_1.setCity("Chicago");
        test_publisher_1.setState("IL");
        test_publisher_1.setPostal_code("65414");
        test_publisher_1.setPhone("321-572-9617");
        test_publisher_1.setEmail("oreilly@gmail.com");

        test_publisher_1 = publisher_repo.save(test_publisher_1);


        book test_book_1 = new book();

        test_book_1.setIsbn(" 1-04-500045-0");
        test_book_1.setPublish_date("2018-04-02");
        test_book_1.setAuthorId(test_author_1.getId());
        test_book_1.setTitle("Beginner SQL");
        test_book_1.setPublisherId(test_publisher_1.getId());
        test_book_1.setPrice(BigDecimal.valueOf(18.76));

        test_book_1 = book_repo.save(test_book_1);

        book test_book_2 = new book();

        test_book_2.setIsbn(" 7-01-465423-3");
        test_book_2.setPublish_date("2012-11-04");
        test_book_2.setAuthorId(test_author_1.getId());
        test_book_2.setTitle("Advanced SQL");
        test_book_2.setPublisherId(test_publisher_1.getId());
        test_book_2.setPrice(BigDecimal.valueOf(22.51));

        test_book_2 = book_repo.save(test_book_2);

        book test_book_3 = new book();

        test_book_3.setIsbn(" 9-06-345841-1");
        test_book_3.setPublish_date("2022-10-16");
        test_book_3.setAuthorId(test_author_1.getId());
        test_book_3.setTitle("Effective and Efficient SQL");
        test_book_3.setPublisherId(test_publisher_1.getId());
        test_book_3.setPrice(BigDecimal.valueOf(25.64));

        test_book_3 = book_repo.save(test_book_3);


        List<book> BookList = book_repo.findBooksByAuthorId(test_author_1.getId());

        assertEquals(BookList.size(), 3);
    }

    //get all Books
    @Test
    public void getAllBooks(){
        author test_author_1=new author();

        test_author_1.setFirst_name("James");
        test_author_1.setLast_name("Vida");
        test_author_1.setStreet("1785 North Boston");
        test_author_1.setCity("Baltimore");
        test_author_1.setState("MD");
        test_author_1.setPostal_code("54687");
        test_author_1.setPhone("589-784-8957");
        test_author_1.setEmail("jvida@gmail.com");

        test_author_1 = author_repo.save(test_author_1);


        author test_author_2=new author();

        test_author_2.setFirst_name("Mike");
        test_author_2.setLast_name("Lowrey");
        test_author_2.setStreet("1879 Edmondson ave");
        test_author_2.setCity("Baltimore");
        test_author_2.setState("MD");
        test_author_2.setPostal_code("21007");
        test_author_2.setPhone("471-635-8541");
        test_author_2.setEmail("mlowrey@gmail.com");

        test_author_2 = author_repo.save(test_author_2);

        publisher test_publisher_1=new publisher();

        test_publisher_1.setName ("OReilly");
        test_publisher_1.setStreet("1266 Frankford Ave");
        test_publisher_1.setCity("Chicago");
        test_publisher_1.setState("IL");
        test_publisher_1.setPostal_code("65414");
        test_publisher_1.setPhone("321-572-9617");
        test_publisher_1.setEmail("oreilly@gmail.com");

        test_publisher_1 = publisher_repo.save(test_publisher_1);


        book test_book_1 = new book();

        test_book_1.setIsbn(" 1-04-500045-0");
        test_book_1.setPublish_date("2018-04-02");
        test_book_1.setAuthorId(test_author_1.getId());
        test_book_1.setTitle("Beginner SQL");
        test_book_1.setPublisherId(test_publisher_1.getId());
        test_book_1.setPrice(BigDecimal.valueOf(18.76));

        test_book_1 = book_repo.save(test_book_1);

        book test_book_2 = new book();

        test_book_2.setIsbn(" 7-01-465423-3");
        test_book_2.setPublish_date("2012-11-04");
        test_book_2.setAuthorId(test_author_2.getId());
        test_book_2.setTitle("Advanced SQL");
        test_book_2.setPublisherId(test_publisher_1.getId());
        test_book_2.setPrice(BigDecimal.valueOf(22.51));

        test_book_2 = book_repo.save(test_book_2);

        book test_book_3 = new book();

        test_book_3.setIsbn(" 9-06-345841-1");
        test_book_3.setPublish_date("2022-10-16");
        test_book_3.setAuthorId(test_author_1.getId());
        test_book_3.setTitle("Effective and Efficient SQL");
        test_book_3.setPublisherId(test_publisher_1.getId());
        test_book_3.setPrice(BigDecimal.valueOf(25.64));

        test_book_3 = book_repo.save(test_book_3);

        book test_book_4 = new book();

        test_book_4.setIsbn(" 5-14-354126-2");
        test_book_4.setPublish_date("2010-02-17");
        test_book_4.setAuthorId(test_author_2.getId());
        test_book_4.setTitle("Java Patterns");
        test_book_4.setPublisherId(test_publisher_1.getId());
        test_book_4.setPrice(BigDecimal.valueOf(12.99));

        test_book_4 = book_repo.save(test_book_4);

        List<book> BookList = book_repo.findAll();

        assertEquals(BookList.size(), 4);
    }

}

