package io.litl.controller;

import io.litl.model.LitlioEntry;
import io.litl.model.LitlioLogEntry;
import io.litl.service.LitlioEntryService;
import io.litl.service.LitlioLogEntryService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.litl.LitlioApplication.count;

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

        LitlioEntry litlioEntry = new LitlioEntry();

        litlioEntry.setLongURL("https://enter.your.long.url.here.com/");

        if (count.getCount() == null) {
            count.setCount(litlioEntryService.getLitlioEntryCount());
        }

        model.addAttribute("litlioCount", count);
        model.addAttribute("litlioEntry", litlioEntry);
        return "index";
    }

    @RequestMapping(value = {"/robots", "/robot", "/robot.txt", "/robots.txt"})
    public void robot(HttpServletResponse response) {

        InputStream resourceAsStream = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            resourceAsStream = classLoader.getResourceAsStream("static/robots.txt");

            response.addHeader("Content-disposition", "filename=robots.txt");
            response.setContentType("text/plain");
            IOUtils.copy(resourceAsStream, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            System.out.println("Problem with displaying robots.txt");
        }
    }

    @RequestMapping("/{aliasURL}")
    public String getLitlioEntry(@PathVariable String aliasURL, Model model, HttpServletRequest request) {

        Date dateTime = new Date();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStamp = simpleDateFormat.format(dateTime);

        LitlioEntry litlioEntry = litlioEntryService.getLitlioEntryByAliasURL(aliasURL);

        LitlioLogEntry litlioLogEntry = new LitlioLogEntry();
        litlioLogEntry.setLitlioEntryId(litlioEntry.getId());
        litlioLogEntry.setIpAddress(request.getHeader("X-Forwarded-For"));
        litlioLogEntry.setUserAgent(request.getHeader("user-agent"));
        litlioLogEntry.setReferer(request.getHeader("referer"));
        litlioLogEntry.setTimestamp(timeStamp);

        litlioLogEntryService.addLitlioLogEntry(litlioLogEntry);

        String redirectURL;

        if (litlioEntry.getLongURL().indexOf("http") == -1) {
            redirectURL = "http://" + litlioEntry.getLongURL();
        } else {
            redirectURL = litlioEntry.getLongURL();
        }

        return "redirect:" + redirectURL;

    }

}
