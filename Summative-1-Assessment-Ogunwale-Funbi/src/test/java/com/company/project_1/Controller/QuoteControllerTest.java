package com.company.project_1.Controller;

import com.company.project_1.Model.Quote;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QuoteController.class)
public class QuoteControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // A list of Quotes for testing purposes
    private List<Quote> quoteList;

    @Before
    public void setUp() {
        // Standard set up method, for instantiating test objects

    }

    private static int idCounter =0;
    // Testing GET /records

    // Testing GET record/{id}
    @Test
    public void shouldReturnAQuote() throws Exception {


        quoteList = new ArrayList<>();

        quoteList.add(new Quote( idCounter++,"Stephen Chbosky","Even if we don't have the power to choose where we come from, we can still choose where we go from there."));
        quoteList.add(new Quote( idCounter++,"John Steinbeck","And now that you don't have to be perfect, you can be good."));
        quoteList.add(new Quote( idCounter++, "Oscar Wilde", "Life is never fair, and perhaps it is a good thing for most of us that it is not."));
        quoteList.add(new Quote( idCounter++, "Nelson Mandela", "The greatest glory in living lies not in never falling, but in rising every time we fall"));
        quoteList.add(new Quote( idCounter++, "Walt Disney", "The way to get started is to quit talking and begin doing."));
        quoteList.add(new Quote( idCounter++, "Eleanor Roosevelt", "If life were predictable it would cease to be life, and be without flavor."));
        quoteList.add(new Quote( idCounter++, "James Cameron", "If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success."));
        quoteList.add(new Quote( idCounter++, "Aristotle", "It is during our darkest moments that we must focus to see the light."));
        quoteList.add(new Quote( idCounter++, "Anne Frank", "Whoever is happy will make others happy too."));
        quoteList.add(new Quote( idCounter++, "Benjamin Franklin", "Tell me and I forget. Teach me and I remember. Involve me and I learn."));

        String outputJson = mapper.writeValueAsString(quoteList);

        mockMvc.perform(get("/quote"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
