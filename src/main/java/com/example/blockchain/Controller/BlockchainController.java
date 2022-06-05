package com.example.blockchain.Controller;

import com.example.blockchain.Models.Blockchain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlockchainController {
    @GetMapping("/blockchain")
    public String redirectBlockchain(Model model) {
        Blockchain blockchain = new Blockchain(10D, 3);
        blockchain.addBlock("long");
        blockchain.addBlock("nam");
        blockchain.addBlock("thanh");
        blockchain.addBlock("thanh");
        blockchain.addBlock("thanh");
        model.addAttribute("blockchain", blockchain.getChain());
        return "blockchain";
    }
}
