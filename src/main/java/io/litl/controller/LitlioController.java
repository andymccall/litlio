package io.litl.controller;

import io.litl.model.LitlioEntry;
import io.litl.model.LitlioLogEntry;
import io.litl.service.LitlioEntryService;
import io.litl.service.LitlioLogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andym on 10/03/2016.
 * .ylutsV1OiW0
 */
@Controller
public class LitlioController {

    LitlioEntryService litlioEntryService;
    LitlioLogEntryService litlioLogEntryService;

    @Autowired
    public void setProductService(LitlioEntryService litlioEntryService) {
        this.litlioEntryService = litlioEntryService;
    }

    @Autowired
    public void setProductService(LitlioLogEntryService litlioLogEntryService) {
        this.litlioLogEntryService = litlioLogEntryService;
    }

    @RequestMapping("/entry/{id}")
    public String getLitlioEntry(@PathVariable Integer id, Model model) {

        LitlioEntry litlioEntry;
        litlioEntry = litlioEntryService.getLitlioEntryByID(id);
        System.out.println("Litlio: " + litlioEntry.toString());

        List<LitlioLogEntry> litlioLogEntries;
        System.out.println("Getting logs for ID: " + litlioEntry.getId());
        litlioLogEntries = litlioLogEntryService.listLitlioLogEntriesByID(litlioEntry.getId());
        System.out.println("LitlioEntries: " + litlioLogEntries.toString());

        litlioEntry.setHitCount(litlioLogEntries.size());
        System.out.println("Size: " + litlioLogEntries.size());

        model.addAttribute("litlioEntry", litlioEntry);
        model.addAttribute("litlioLogEntries", litlioLogEntries);

        return "litlioEntry";
    }

    @RequestMapping("/entry/new")
    public String newLitlioEntry(Model model) {

        model.addAttribute("litlioEntry", new LitlioEntry());

        return "litlioEntryForm";
    }

    @RequestMapping(value = "/entry", method = RequestMethod.POST)
    public String createLitlioEntry(LitlioEntry litlioEntry) {

        System.out.println(litlioEntry.toString());

        LitlioEntry savedLitlioEntry = litlioEntryService.addLitlioEntry(litlioEntry);
        return "redirect:/entry/" + savedLitlioEntry.getId();

    }
}

