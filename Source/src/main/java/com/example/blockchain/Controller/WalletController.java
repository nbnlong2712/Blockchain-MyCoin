package com.example.blockchain.Controller;

import com.example.blockchain.MainBlockchain;
import com.example.blockchain.MainWallet;
import com.example.blockchain.Models.Wallet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WalletController {

    @GetMapping("/wallet")
    public String wallet(Model model) {
        if (MainWallet.getMainWallet() != null) {
            MainWallet.getMainWallet().getBalanceCoin(MainBlockchain.getMainBlockchain());
            model.addAttribute("wallet", MainWallet.getMainWallet());
        } else {
            model.addAttribute("wallet", new Wallet());
        }
        return "wallet";
    }
}
