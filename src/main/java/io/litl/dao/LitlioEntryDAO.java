package io.litl.dao;

import io.litl.model.LitlioEntry;

import java.util.List;

/**
 * Created by andym on 10/03/2016.
 */
public interface LitlioEntryDAO {

    public void addLitlioEntry(LitlioEntry litlioEntry);
    public LitlioEntry getLitlioEntryByID(int id);
    public LitlioEntry getLitlioEntryByAliasURL(String aliasURL);
    public List<LitlioEntry> listLitlioEntries();
    public Long getLitlioEntryCount();

}
