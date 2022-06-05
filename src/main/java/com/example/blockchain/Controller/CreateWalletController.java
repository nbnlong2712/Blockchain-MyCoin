package com.example.blockchain.Controller;

import com.example.blockchain.Interface.PeerRepository;
import com.example.blockchain.Models.Peer;
import com.example.blockchain.Service.PeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateWalletController {
    @Autowired
    private PeerRepository peerRepository;

    @GetMapping("/create-wallet")
    public String redirectCreateWallet() {
        return "create_wallet";
    }

    @PostMapping("/create-wallet")
    public String checkCreateWallet(ModelMap modelMap, Peer peer) {
        if (PeerService.isUsernameExists(peerRepository, peer)) {
            peerRepository.save(peer);
            return "redirect:/blockchain";
        }
        else {
            modelMap.addAttribute("ERROR", "Username not valid!");
            return "create_wallet";
        }
    }
}
