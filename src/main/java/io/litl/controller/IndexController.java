package io.litl.controller;

import io.litl.model.LitlioEntry;
import io.litl.model.LitlioLogEntry;
import io.litl.service.LitlioEntryService;
import io.litl.service.LitlioLogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by andym on 10/03/2016.
 */
@Controller
public class IndexController {

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

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("litlioEntry", new LitlioEntry());
        return "index";
    }

    @RequestMapping("/{shortURL}")
    public String getLitlioEntry(@PathVariable String shortURL, Model model, HttpServletRequest request) {

        Date dateTime = new Date();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStamp = simpleDateFormat.format(dateTime);

        LitlioEntry litlioEntry = litlioEntryService.getLitlioEntryByShortURL(shortURL);
        System.out.println(litlioEntry.toString());

        LitlioLogEntry litlioLogEntry = new LitlioLogEntry();
        litlioLogEntry.setLitlioEntryId(litlioEntry.getId());
        litlioLogEntry.setIpAddress(request.getHeader("X-Forwarded-For"));
        litlioLogEntry.setUserAgent(request.getHeader("user-agent"));
        litlioLogEntry.setReferer(request.getHeader("referer"));
        litlioLogEntry.setTimestamp(timeStamp);

        litlioLogEntryService.addLitlioLogEntry(litlioLogEntry);

        return "redirect:" + litlioEntry.getLongURL();

    }

}
