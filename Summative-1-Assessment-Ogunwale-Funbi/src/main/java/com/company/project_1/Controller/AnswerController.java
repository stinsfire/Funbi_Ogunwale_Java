package com.company.project_1.Controller;

import com.company.project_1.Model.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class AnswerController {

    private List<Answer> answerList;

    private static int idCounter = 0;

    public AnswerController() {
        answerList = new ArrayList<>();

        String Question="";

        answerList.add(new Answer( idCounter++,Question,"It is certain."));
        answerList.add(new Answer( idCounter++,Question,"As I see it, yes."));
        answerList.add(new Answer( idCounter++, Question, " Reply hazy, try again."));
        answerList.add(new Answer( idCounter++, Question, "Don't count on it."));
        answerList.add(new Answer( idCounter++, Question, " It is decidedly so."));
        answerList.add(new Answer( idCounter++, Question, "Most likely."));
        answerList.add(new Answer( idCounter++, Question, "Ask again later."));
        answerList.add(new Answer( idCounter++, Question, "My reply is no."));
        answerList.add(new Answer( idCounter++, Question, " Without a doubt."));
        answerList.add(new Answer( idCounter++, Question, " Outlook good."));
        answerList.add(new Answer( idCounter++, Question, " Better not tell you now."));
        answerList.add(new Answer( idCounter++, Question, " My sources say no."));
        answerList.add(new Answer( idCounter++, Question, " Yes definitely."));
        answerList.add(new Answer( idCounter++, Question, " Yes."));
        answerList.add(new Answer( idCounter++, Question, " Cannot predict now."));
        answerList.add(new Answer( idCounter++, Question, " Outlook not so good."));
        answerList.add(new Answer( idCounter++, Question, " You may rely on it."));
        answerList.add(new Answer( idCounter++, Question, " Signs point to yes."));
        answerList.add(new Answer( idCounter++, Question, " Concentrate and ask again."));
        answerList.add(new Answer( idCounter++, Question, " Very doubtful."));
    }

    @RequestMapping(value = "/Answer", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Answer getAnswer(@RequestBody (required = false) String question){
        Random rand = new Random();
        int upperbound = answerList.size();
        int int_random = rand.nextInt(upperbound);

        Answer response_object;
        response_object= answerList.get(int_random);
        response_object.setId(int_random);
        response_object.setQuestion(question);
        return response_object;
    }

}
