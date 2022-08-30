package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public Customer(String id, String name, String charge, String chargeDate) {
        setId(Integer.parseInt(id));
        setName(name);
        setCharges(charge, chargeDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharges(String charge, String chargeDate){
        charges.add(new AccountRecord(charge, chargeDate));
    }

    public int getBalance() {
        //update this
        int balance=0;
        for (AccountRecord record:charges){
            balance+=record.getCharge();
        }
        return balance;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        //update this
        return ("Customer ID: " + getId() + "\nCustomer name: " + getName() + "\nCustomer balance: " + getBalance());
    }
}
