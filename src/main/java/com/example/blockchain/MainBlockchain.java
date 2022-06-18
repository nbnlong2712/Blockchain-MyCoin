package com.example.blockchain;


import com.example.blockchain.Models.Blockchain;
import com.example.blockchain.Models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MainBlockchain {
    private static Blockchain mainBlockchain;
    private static List<Transaction> historyTransactions;

    public static Blockchain getMainBlockchain() {
        return mainBlockchain;
    }

    public static void setMainBlockchain(Blockchain mainBlockchain) {
        MainBlockchain.mainBlockchain = mainBlockchain;
    }

    public static List<Transaction> getHistoryTransactions() {
        return historyTransactions;
    }

    public static void setHistoryTransactions(List<Transaction> historyTransactions) {
        MainBlockchain.historyTransactions = historyTransactions;
    }
}
