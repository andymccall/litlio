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

import static io.litl.LitlioApplication.count;

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

    @RequestMapping({"/view/{shortURL]", "/v/{shortURL}"})
    public String getLitlioEntry(@PathVariable String shortURL, Model model) {

        LitlioEntry litlioEntry;
        litlioEntry = litlioEntryService.getLitlioEntryByShortURL(shortURL);

        List<LitlioLogEntry> litlioLogEntries;
        litlioLogEntries = litlioLogEntryService.listLitlioLogEntriesByID(litlioEntry.getId());

        litlioEntry.setHitCount(litlioLogEntries.size());

        model.addAttribute("litlioEntry", litlioEntry);
        model.addAttribute("litlioLogEntries", litlioLogEntries);

        return "view";
    }

    @RequestMapping("/id/{id}")
    public String getLitlioEntry(@PathVariable Integer id, Model model) {

        LitlioEntry litlioEntry;
        litlioEntry = litlioEntryService.getLitlioEntryByID(id);

        List<LitlioLogEntry> litlioLogEntries;
        litlioLogEntries = litlioLogEntryService.listLitlioLogEntriesByID(litlioEntry.getId());

        litlioEntry.setHitCount(litlioLogEntries.size());

        model.addAttribute("litlioEntry", litlioEntry);
        model.addAttribute("litlioLogEntries", litlioLogEntries);

        return "view";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createLitlioEntry(LitlioEntry litlioEntry) {

        LitlioEntry savedLitlioEntry = litlioEntryService.addLitlioEntry(litlioEntry);

        if (count.getCount() == null) {
            count.setCount(litlioEntryService.getLitlioEntryCount());
        } else {
            count.incrementCount();
        }

        return "redirect:/v/" + savedLitlioEntry.getShortURL();

    }
}

