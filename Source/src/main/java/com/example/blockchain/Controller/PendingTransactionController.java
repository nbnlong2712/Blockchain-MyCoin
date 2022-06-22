package com.example.blockchain.Controller;

import com.example.blockchain.MainBlockchain;
import com.example.blockchain.MainWallet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PendingTransactionController {

    @GetMapping("/pending_transaction")
    public String pendingTransaction(Model model) {
        int size = MainBlockchain.getMainBlockchain().getPendingTransactions().size();
        if (size <= 1) {
            model.addAttribute("pending_transaction", 0);
        } else {
            model.addAttribute("pending_transaction", size);
        }
        return "pending_transaction";
    }

    @RequestMapping(value = "/mining")
    public String doMining() {
        System.out.println("Mining in process...");
        int size = MainBlockchain.getMainBlockchain().getPendingTransactions().size();
        if (size > 1) {
            MainBlockchain.getMainBlockchain().mineBlock(MainWallet.getMainWallet().getPublicKey());
        }
        return "history";
    }
}
