package com.example.blockchain.Controller;

import com.example.blockchain.Models.Blockchain;
import com.example.blockchain.Models.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlockchainController {
    @GetMapping("/blockchain")
    public String redirectBlockchain(Model model) {
        Blockchain blockchain = new Blockchain(10D, 3);
        blockchain.createTransaction(new Transaction("Long", "Dat", 15.0));
        blockchain.createTransaction(new Transaction("Dat", "Long", 25.0));
        blockchain.mineBlock("long");
        blockchain.createTransaction(new Transaction("Long", "Thanh", 155.0));
        blockchain.mineBlock("nam");
        blockchain.mineBlock("hoang");
        blockchain.mineBlock("thanh");
        blockchain.createTransaction(new Transaction("Long", "Tin", 125.0));
        blockchain.createTransaction(new Transaction("Long", "Hoang", 135.0));
        blockchain.createTransaction(new Transaction("Long", "Sadio Mane", 15555.0));
        blockchain.mineBlock("minh");
        model.addAttribute("blockchain", blockchain.getChain());
        return "blockchain";
    }
}
