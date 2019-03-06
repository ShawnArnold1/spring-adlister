package com.codeup.adlister.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiceController
{
    @GetMapping("/rolldice")
    public String rollHome()
    {
        return "roll";
    }

    @GetMapping("/rolldice/{userNumber}")
    public String rollDice(@PathVariable int userNumber, Model model)
    {
        int pcRoll = (int) (Math.random() * 6) + 1;
        Boolean matchyMatchy = false;
        model.addAttribute("pcRoll", pcRoll);
        model.addAttribute("userNumber", userNumber);
        if(userNumber == pcRoll)
        {
            matchyMatchy = true;
        }
        model.addAttribute("matchy", matchyMatchy);
        return "pcRoll";
    }

}
