package com.example.blockchain.Service;

import com.example.blockchain.Interface.WalletRepository;
import com.example.blockchain.Models.Wallet;

import java.util.List;

public class WalletService {
    public static boolean isUsernameExists(WalletRepository repository, Wallet wallet) {
        List<Wallet> wallets = repository.findAll();
        for (Wallet wallet1 : wallets) {
            if (wallet.getUsername().equals(wallet1.getUsername()))
                return false;
        }
        return true;
    }

    public static boolean isLoginSuccess(WalletRepository repository, String username, String password) {
        List<Wallet> wallets = repository.findAll();
        for (Wallet wallet1 : wallets) {
            if (wallet1.getUsername().equals(username) && wallet1.getPassword().equals(password))
                return true;
        }
        return false;
    }

    public static Wallet findByUsername(WalletRepository repository, String username) {
        Wallet wallet = new Wallet();
        List<Wallet> wallets = repository.findAll();
        for (Wallet wallet1 : wallets) {
            if (wallet1.getUsername().equals(username)) {
                wallet = wallet1;
                break;
            }
        }
        return wallet;
    }
}
