package org.launchcode.cheesemvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {


    HashMap<String, String> cheeses = new HashMap<>();



    static ArrayList<String> cheese_remove = new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String description) {
        cheeses.put(cheeseName, description);
        if (cheeseName.equals("")) {
            String error = "Please submit a cheese";
            return "cheese/add";

        }
        return "redirect:";

    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("title", "Remove Cheese");
        //model.addAttribute("cheese", cheese_remove);
        model.addAttribute("cheeses", this.cheeses);
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam String cheese) {
            cheese_remove.add(cheese);

            for (String cheese2: cheese_remove) {
                cheeses.remove(cheese2);
            }

            return "redirect:";
        }

    @RequestMapping(value = "remove2", method = RequestMethod.GET)
    public String displayRemoveCheeseForm2(Model model) {
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", cheeses);
        return "cheese/remove2";
    }

    @RequestMapping(value = "remove2", method = RequestMethod.POST)
    public String processRemoveCheeseForm2(@RequestParam String cheese) {
        cheeses.remove(cheese);


        return "redirect:";
    }
    }






