package com.example.blockchain.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String redirectLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String checkLogin()
    {
        return "blockchain";
    }

    @GetMapping("/logout")
    public String logout()
    {
        return "login";
    }
}