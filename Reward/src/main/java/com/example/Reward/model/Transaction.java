package com.example.Reward.model;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class Transaction{

    private int id;
    private int customerId;
    private String date;
    private double amount;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public Transaction(int id, int customerId, String date, double amount){
        this.id = id;
        this.customerId = customerId;
        this.date = date;
        this.amount = amount;
    }
}
