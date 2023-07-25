package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class QuoteController {


    @GetMapping("/quote")
    public String getQuote(Model model) {
        String[] quotes = {
                "When you have faults, do not fear to abandon them.",
                "They must often change who would be constant in happiness or wisdom.",
                "Age is no guarantee of maturity.",
                "Youth isn’t always all it’s touted to be",
                "You will face many defeats in life, but never let yourself be defeated."
        };


        int idx = (int) (Math.random()* quotes.length);
        model.addAttribute("quote", quotes[idx]);

        return "quote";
    }
}
