package io.litl.controller;

import io.litl.model.LitlioEntry;
import io.litl.service.LitlioEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by andym on 10/03/2016.
 */
@Controller
public class IndexController {

    LitlioEntryService litlioEntryService;

    @Autowired
    public void setProductService(LitlioEntryService litlioEntryService) {
        this.litlioEntryService = litlioEntryService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("litlioEntry", new LitlioEntry());
        return "index";
    }

    @RequestMapping("/{shortURL}")
    public String getLitlioEntry(@PathVariable String shortURL, Model model) {

        LitlioEntry litlioEntry = litlioEntryService.getLitlioEntryByShortURL(shortURL);

        return "redirect:" + litlioEntry.getLongURL();

    }

}
