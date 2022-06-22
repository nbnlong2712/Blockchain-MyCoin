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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CreateWalletController {
    @Autowired
    private WalletRepository walletRepository;

    @GetMapping("/create-wallet")
    public String redirectCreateWallet(Model model) {
        model.addAttribute("wallet", new Wallet());
        return "create_wallet";
    }

    @PostMapping("/create-wallet")
    public String checkCreateWallet(ModelMap modelMap, @ModelAttribute Wallet wallet) {
        if (WalletService.isUsernameExists(walletRepository, wallet)) {
            walletRepository.save(wallet);
            return "redirect:/";
        } else {
            modelMap.addAttribute("ERROR", "Username not valid!");
            return "create_wallet";
        }
    }
}
