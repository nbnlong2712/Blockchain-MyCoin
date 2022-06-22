package com.example.blockchain.Models;

import com.google.common.annotations.Beta;
import com.google.common.hash.Hashing;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Block {
    private Integer id;
    private String hash;
    private String previousHash;
    private Long nonce;
    private Date timeStamp;
    private List<Transaction> transactions;

    private Block(){}

    public Block(String previousHash, Date timeStamp, List<Transaction> transactions) {
        this.previousHash = previousHash;
        this.nonce = 0L;
        this.timeStamp = timeStamp;
        this.transactions = transactions;
        this.hash = this.calculateHash();
    }

    //GET, SET
    public String getHash() {
        return hash;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }
    public String getPreviousHash() {
        return previousHash;
    }
    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }
    public Long getNonce() {
        return nonce;
    }
    public void setNonce(Long nonce) {
        this.nonce = nonce;
    }
    public Date getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    //-----------------------------------------------------------------------------------------------
    public String calculateHash(){
        String calHash = previousHash + timeStamp.toString() + transactions + nonce.toString();
        return DigestUtils.sha256Hex(calHash);
    }

    public void mineBlock(int difficulty)
    {
        String header = "0".repeat(difficulty);
        while (!hash.startsWith(header))
        {
            hash = calculateHash();
            nonce++;
        }
    }

    @Override
    public String toString() {
        return "Block{" +
                "hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", nonce=" + nonce +
                ", timeStamp=" + timeStamp +
                ", transactions=" + transactions +
                '}';
    }

    public void displayBlock()
    {
        System.out.println("{");
        System.out.println(" Previous Hash: " + previousHash);
        System.out.println(" Timestamp: " + timeStamp);
        System.out.println(" Nonce: " + nonce);
        System.out.println(" Transactions: " + transactions);
        System.out.println(" Hash: " + hash);
        System.out.println("}");
    }
}
