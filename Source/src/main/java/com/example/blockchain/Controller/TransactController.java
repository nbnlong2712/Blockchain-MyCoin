package com.example.blockchain.Controller;

import com.example.blockchain.MainBlockchain;
import com.example.blockchain.MainWallet;
import com.example.blockchain.Models.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransactController {
    @GetMapping("/transact")
    public String transact(Model model) {
        Transaction transaction = new Transaction();
        if (MainWallet.getMainWallet() != null) {
            transaction.setFrom(MainWallet.getMainWallet().getPublicKey());
        }
        model.addAttribute("transaction", transaction);
        return "transact";
    }

    @PostMapping("/transact")
    public String transactCoin(ModelMap modelMap, @ModelAttribute Transaction transaction) {
        if (MainWallet.getMainWallet() != null) {
            if (transaction.getAmount() < MainWallet.getMainWallet().getBalance()) {
                if (MainBlockchain.getMainBlockchain() != null) {
                    MainBlockchain.getMainBlockchain().createTransaction(transaction);
                    MainBlockchain.getHistoryTransactions().add(transaction);
                }
                return "pending_transaction";
            } else {
                modelMap.addAttribute("ERROR", "Balance not enough!");
                return "transact";
            }
        } else {
            modelMap.addAttribute("ERROR", "Balance not enough!");
            return "transact";
        }
    }
}
