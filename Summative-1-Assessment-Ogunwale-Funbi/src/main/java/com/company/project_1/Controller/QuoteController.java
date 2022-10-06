package com.company.project_1.Controller;

import com.company.project_1.Model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteController {
    private List<Quote> quoteList;

    private static int idCounter =0;

    public QuoteController() {
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
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote(){
        Random rand = new Random();
        int upperbound = quoteList.size();
        int int_random = rand.nextInt(upperbound);
        return quoteList.get(int_random);
    }

}