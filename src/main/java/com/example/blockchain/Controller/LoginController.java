package com.example.blockchain.Controller;

import com.example.blockchain.Interface.WalletRepository;
import com.example.blockchain.MainBlockchain;
import com.example.blockchain.MainWallet;
import com.example.blockchain.Models.Blockchain;
import com.example.blockchain.Models.Wallet;
import com.example.blockchain.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class LoginController {
    @Autowired
    private WalletRepository walletRepository;

    @GetMapping("/")
    public String redirectLogin(Model model) {
        model.addAttribute("loginWallet", new Wallet());
        return "login";
    }

    @PostMapping("/")
    public String checkLogin(ModelMap modelMap, @ModelAttribute Wallet wallet) {
        if (WalletService.isLoginSuccess(walletRepository, wallet.getUsername(), wallet.getPassword())) {
            if (MainBlockchain.getMainBlockchain() == null) {
                MainBlockchain.setMainBlockchain(new Blockchain(10D, 2));
            }
            if (MainBlockchain.getHistoryTransactions() == null) {
                MainBlockchain.setHistoryTransactions(new ArrayList<>());
            }
            Wallet wallet1 = WalletService.findByUsername(walletRepository, wallet.getUsername());
            wallet1.getBalanceCoin(MainBlockchain.getMainBlockchain());
            MainWallet.setMainWallet(wallet1);
            return "home";
        } else {
            modelMap.addAttribute("ERROR", "Credential not valid!");
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        MainWallet.setMainWallet(null);
        return "redirect:/";
    }
}