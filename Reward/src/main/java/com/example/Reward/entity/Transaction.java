package com.example.Reward.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class Transaction {

    private int id;
    private int customerId;
    private Date date;
    private double amount;

    public Transaction(int id, int customerId, Date date, double amount){
        this.id = id;
        this.customerId = customerId;
        this.date = date;
        this.amount = amount;
    }
}
