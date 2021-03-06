package com.example.blockchain.Models;

import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;
import java.util.Date;

public class Transaction {
    private Integer id;
    private String from;
    private String to;
    private double amount;

    public Transaction() {
    }

    public Transaction(String from, String to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    //-----------------------------------------------------------
    //-----------------------------------------------------------
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                '}';
    }
}
