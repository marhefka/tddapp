package com.training360.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TanarManagementHtmlController {
    private List<TanarDTO> tanarok = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tanarok", tanarok);
        model.addAttribute("ujTanar", new TanarDTO());
        return "index";
    }

    @PostMapping("/letrehozTanart")
    public String letrehozTanart(@ModelAttribute TanarDTO tanar) {
        tanarok.add(tanar);
        return "redirect:/";
    }
}
