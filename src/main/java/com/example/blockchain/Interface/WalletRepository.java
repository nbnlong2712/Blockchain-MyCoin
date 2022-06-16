package com.example.blockchain.Interface;

import com.example.blockchain.Models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
}
