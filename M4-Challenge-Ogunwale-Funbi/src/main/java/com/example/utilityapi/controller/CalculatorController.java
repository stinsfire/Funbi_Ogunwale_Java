package com.example.utilityapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.*;

import static java.lang.Integer.MAX_VALUE;

@RestController
public class CalculatorController {

    public CalculatorController() {
    }

    @RequestMapping(value = "/calculator/divide", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public double divide(@Valid @RequestParam int value1, @Valid @RequestParam  int value2) {

        if (value2==0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST) ;
        }
        return value1 / value2;
    }

    @RequestMapping(value = "/calculator/square/{value}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public int square(@PathVariable @Valid int value) {
        if (((long)value* (long) value)>Integer.MAX_VALUE ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return value * value;

    }
}
