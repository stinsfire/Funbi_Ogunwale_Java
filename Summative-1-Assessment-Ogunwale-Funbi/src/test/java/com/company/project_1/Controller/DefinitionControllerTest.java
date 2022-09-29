package com.company.project_1.Controller;


import com.company.project_1.Model.Definition;
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
@WebMvcTest(DefinitionController.class)
public class DefinitionControllerTest {
    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // A list of words for testing purposes
    private List<Definition> definitionList;

    @Before
    public void setUp() {
        // Standard set up method, for instantiating test objects

    }

    private static int wordIdCounter=0;

    // Testing GET /word
    @Test
    public void shouldReturnAWordAndItsDefinition() throws Exception {

        definitionList = new ArrayList<>();

        definitionList.add(new Definition( wordIdCounter++,"flokati","a thick, woolen rug with a shaggy pile, originally handwoven in Greece."));
        definitionList.add(new Definition( wordIdCounter++,"lido","a fashionable beach resort."));
        definitionList.add(new Definition( wordIdCounter++, "perse", "of a very deep shade of blue or purple."));
        definitionList.add(new Definition( wordIdCounter++, "ailurophile", "a person who likes cats"));
        definitionList.add(new Definition( wordIdCounter++, "veracious", "characterized by truthfulness"));
        definitionList.add(new Definition( wordIdCounter++, "arioso", "in the manner of an air or melody."));
        definitionList.add(new Definition( wordIdCounter++, "zophorus", "a frieze having representations of people or animals."));
        definitionList.add(new Definition( wordIdCounter++, "meliorism", "the doctrine that the world tends to become better or may be made better by human effort."));
        definitionList.add(new Definition( wordIdCounter++, "xenial", " warm, welcoming, and hospitable"));
        definitionList.add(new Definition( wordIdCounter++, "musaceous", "of or relating to the fruit of the tropical treelike plants of the banana family, especially bananas and plantains"));

        String outputJson = mapper.writeValueAsString(definitionList);

        mockMvc.perform(get("/word"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
