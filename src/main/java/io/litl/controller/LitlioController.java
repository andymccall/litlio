package io.litl.controller;

import io.litl.model.LitlioEntry;
import io.litl.service.LitlioEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by andym on 10/03/2016.
 */
@Controller
public class LitlioController {

    LitlioEntryService litlioEntryService;

    @Autowired
    public void setProductService(LitlioEntryService litlioEntryService) {
        this.litlioEntryService = litlioEntryService;
    }

    @RequestMapping("/entry/{id}")
    public String getLitlioEntry(@PathVariable Integer id, Model model) {

        model.addAttribute("litlioEntry", litlioEntryService.getLitlioEntryByID(id));

        return "litlioEntry";
    }

    @RequestMapping("/entry/new")
    public String newLitlioEntry(Model model) {

        model.addAttribute("litlioEntry", new LitlioEntry());

        return "litlioEntryForm";
    }
}

