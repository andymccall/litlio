package io.litl.service;

import io.litl.model.LitlioEntry;

import java.util.List;

/**
 * Created by andym on 10/03/2016.
 */
public interface LitlioEntryService {

    public LitlioEntry addLitlioEntry(LitlioEntry litlioEntry);
    public LitlioEntry getLitlioEntryByID(int id);
    public LitlioEntry getLitlioEntryByShortURL(String shortURL);
    public List<LitlioEntry> listLitlioEntries();
    public Long getLitlioEntryCount();

}
