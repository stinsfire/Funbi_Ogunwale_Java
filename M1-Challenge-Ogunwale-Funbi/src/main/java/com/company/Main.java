package com.company;

import java.util.*;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );
    public static void main(String[] args) {
        //Update this
        List<Customer> customers=new ArrayList<Customer>();

        Map<Integer,Customer> unique = new HashMap<>();

        for (String[] i:customerData){
            Customer customer=new Customer(i[0],i[1],i[2],i[3]);
            customers.add(customer);
            }


        for (Customer c:customers){
                unique.put(c.getId(), c);
            }

        System.out.println(unique);
        System.out.println("----------------------------");


        //printing out accounts that are positive
        System.out.println("Positive accounts:");
        System.out.println("----------------------------");
        for (Customer c:customers){
            if (c.getBalance()>0){
                System.out.println(c);
            }
        }


        //printing out accounts that are negative
        System.out.println("----------------------------");
        System.out.println("Negative accounts:");
        System.out.println("----------------------------");
        for (Customer c:customers){
            if (c.getBalance()< 0){
                System.out.println(c);
            }
        }

    }
}
