package com.example.blockchain.Controller;

import com.example.blockchain.Interface.WalletRepository;
import com.example.blockchain.Models.Wallet;
import com.example.blockchain.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private WalletRepository walletRepository;

    @GetMapping("/")
    public String redirectLogin(Model model) {
        model.addAttribute("login", new Wallet());
        return "login";
    }

    @PostMapping("/")
    public String checkLogin(ModelMap modelMap, @ModelAttribute Wallet wallet) {
        if (WalletService.isLoginSuccess(walletRepository, wallet.getUsername(), wallet.getPassword())) {
            System.out.println("SUCCESS");
            return "home";
        } else {
            modelMap.addAttribute("ERROR", "Credential not valid!");
            System.out.println("FAILED");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }
}