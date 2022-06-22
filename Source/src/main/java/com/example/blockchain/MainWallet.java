package com.example.blockchain;

import com.example.blockchain.Models.Wallet;

public class MainWallet {
    public static Wallet mainWallet;

    public static Wallet getMainWallet() {
        return mainWallet;
    }

    public static void setMainWallet(Wallet mainWallet) {
        MainWallet.mainWallet = mainWallet;
    }
}
