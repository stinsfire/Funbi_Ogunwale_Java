package com.example.utilityapi.controller;

import com.example.utilityapi.models.Account;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.ArrayList;

@RestController
public class AccountController {

    private List<Account> accountList;

    private static int idCounter = 1;

    public AccountController() {
        accountList = new ArrayList<>();

        accountList.add(new Account("Robert Williams", "TexasAM_44", idCounter++));
        accountList.add(new Account("Danny Ainge", "BYU_44", idCounter++));
        accountList.add(new Account("Brian Scalabrine", "USC_44", idCounter++));
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public Account createAccount(@RequestBody @Valid Account account) {
        for (Account i:accountList){
            if (i.getUsername().toLowerCase().equals((account.getUsername().toLowerCase()))){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }
        account.setId(idCounter++);
        accountList.add(account);


        return account;
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<Account> getAllAccounts() {

        return accountList;
    }

}
