package com.company.project_1.Controller;

import com.company.project_1.Model.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AnswerController.class)
public class AnswerControllerTest {
    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    private List<Answer> answerList;

    private static int idCounter=0;

    // Testing POST /records
    @Test
    public void shouldReturnResponseOnPostRequest() throws Exception {

        // ARRANGE
        Answer inputAnswer = new Answer();

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(inputAnswer);

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

        String outputJson = mapper.writeValueAsString(answerList);

        // ACT
        mockMvc.perform(
                        post("/Answer")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 201)
    }

}
