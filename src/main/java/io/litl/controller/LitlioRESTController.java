package io.litl.controller;

import io.litl.model.LitlioEntry;
import io.litl.model.LitlioEntryCount;
import io.litl.model.LitlioLogEntry;
import io.litl.service.LitlioEntryService;
import io.litl.service.LitlioLogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.litl.LitlioApplication.count;

/**
 * Created by andymccall on 31/05/2016.
 */

@RestController
@RequestMapping("/api")
public class LitlioRESTController {

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

    @RequestMapping(value = "/count", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody LitlioEntryCount getLitlioCount() {

        if (count.getCount() == null) {
            count.setCount(litlioEntryService.getLitlioEntryCount());
        }

        return count;
    }

    @RequestMapping(value = "/v/{aliasURL}", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody
    LitlioEntry getLitlioEntry(@PathVariable String aliasURL) {

        LitlioEntry litlioEntry;
        litlioEntry = litlioEntryService.getLitlioEntryByAliasURL(aliasURL);

        List<LitlioLogEntry> litlioLogEntries;
        litlioLogEntries = litlioLogEntryService.listLitlioLogEntriesByID(litlioEntry.getId());

        litlioEntry.setHitCount(litlioLogEntries.size());

        return litlioEntry;
    }

    @RequestMapping(value = "/c/", method = RequestMethod.POST)
    public ResponseEntity<LitlioEntry> update(@RequestBody LitlioEntry litlioEntry) {

        LitlioEntry createdLitlioEntry = new LitlioEntry();

        if (litlioEntry != null) {
            if (!litlioEntryService.ifExists(litlioEntry.getAliasURL())) {
                createdLitlioEntry = litlioEntryService.addLitlioEntry(litlioEntry);
                if (count.getCount() == null) {
                    count.setCount(litlioEntryService.getLitlioEntryCount());
                } else {
                    count.incrementCount();
                }
            } else
                return new ResponseEntity<LitlioEntry>(createdLitlioEntry, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<LitlioEntry>(createdLitlioEntry, HttpStatus.OK);
    }

}
