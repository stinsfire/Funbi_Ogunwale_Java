package com.company.project_1.Controller;


import com.company.project_1.Model.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class DefinitionController {
    private List<Definition> definitionList;

    private static int wordIdCounter =0;

    public DefinitionController() {
        definitionList = new ArrayList<>();

        definitionList.add(new Definition( wordIdCounter++,"flokati","a thick, woolen rug with a shaggy pile, originally handwoven in Greece."));
        definitionList.add(new Definition( wordIdCounter++,"lido","a fashionable beach resort."));
        definitionList.add(new Definition( wordIdCounter++, "perse", "of a very deep shade of blue or purple."));
        definitionList.add(new Definition( wordIdCounter++, "ailurophile", "a person who likes cats"));
        definitionList.add(new Definition( wordIdCounter++, "veracious", "characterized by truthfulness"));
        definitionList.add(new Definition( wordIdCounter++, "arioso", "n the manner of an air or melody."));
        definitionList.add(new Definition( wordIdCounter++, "zophorus", "a frieze having representations of people or animals."));
        definitionList.add(new Definition( wordIdCounter++, "meliorism", "the doctrine that the world tends to become better or may be made better by human effort."));
        definitionList.add(new Definition( wordIdCounter++, "xenial", " warm, welcoming, and hospitable"));
        definitionList.add(new Definition( wordIdCounter++, "musaceous", "T of or relating to the fruit of the tropical treelike plants of the banana family, especially bananas and plantains"));
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getWord(){
        Random rand = new Random();
        int upperbound = definitionList.size();
        int int_random = rand.nextInt(upperbound);
        return definitionList.get(int_random);
    }
}
