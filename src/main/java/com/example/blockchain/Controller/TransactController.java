package com.example.blockchain.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactController {

    @GetMapping("/transact")
    public String transact(){
        return "transact";
    }

}
