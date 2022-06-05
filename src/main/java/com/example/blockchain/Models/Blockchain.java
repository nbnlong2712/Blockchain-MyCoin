package com.example.blockchain.Models;

import java.util.*;

public class Blockchain {
    private List<Block> chain = new ArrayList<>();
    private Double miningReward;
    private List<Transaction> pendingTransactions;
    private Integer proofOfWorkDifficulty;

    public List<Block> getChain() {
        return chain;
    }

    public void setChain(List<Block> chain) {
        this.chain = chain;
    }

    public List<Transaction> getPendingTransactions() {
        return pendingTransactions;
    }

    public void setPendingTransactions(List<Transaction> pendingTransactions) {
        this.pendingTransactions = pendingTransactions;
    }

    public Integer getProofOfWorkDifficulty() {
        return proofOfWorkDifficulty;
    }

    public void setProofOfWorkDifficulty(Integer proofOfWorkDifficulty) {
        this.proofOfWorkDifficulty = proofOfWorkDifficulty;
    }

    public Double getMiningReward() {
        return miningReward;
    }

    public void setMiningReward(Double miningReward) {
        this.miningReward = miningReward;
    }

    public Blockchain(Double miningReward, Integer proofOfWorkDifficulty) {
        this.miningReward = miningReward;
        this.proofOfWorkDifficulty = proofOfWorkDifficulty;
        this.pendingTransactions = new ArrayList<>();
        this.chain.add(genesisBlock());
    }

    private Block genesisBlock() {
        List<Transaction> transactions = new ArrayList<>(Collections.singletonList(new Transaction("", "", 0L)));
        return new Block("0000", new Date(), transactions);
    }

    private Block lastBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addBlock(String minerAddress) {
        Block lastBlock = this.lastBlock();
        Transaction transaction = new Transaction(null, minerAddress, miningReward);
        pendingTransactions.add(transaction);

        Block block = new Block(lastBlock.getHash(), new Date(), pendingTransactions);
        System.out.println("Start mining...");
        block.mineBlock(proofOfWorkDifficulty);
        System.out.println("Mining success: ");
        block.displayBlock();

        chain.add(block);
        pendingTransactions = new ArrayList<>(Collections.emptyList());
    }

    public boolean isValidChain() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);
            if (!currentBlock.getHash().equals(currentBlock.calculateHash()))
                return false;
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash()))
                return false;
        }
        return true;
    }

    public void displayBlockChain()
    {
        for (Block block : chain)
        {
            System.out.println("{");
            System.out.println(" Previous Hash: " + block.getPreviousHash());
            System.out.println(" Timestamp: " + block.getTimeStamp());
            System.out.println(" Nonce: " + block.getNonce());
            System.out.println(" Transactions: " + block.getTransactions());
            System.out.println(" Hash: " + block.getHash());
            System.out.println("}");
        }
    }

    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain(10D, 5);
        blockchain.addBlock("long");
        blockchain.addBlock("nam");
        blockchain.addBlock("thanh");
    }
}