package io.litl.dao;

import io.litl.model.LitlioEntry;
import io.litl.model.LitlioLogEntry;
import java.util.List;

/**
 * Created by andymccall on 19/05/2016.
 */
public interface LitlioLogEntryDAO {

    public void addLitlioLogEntry(LitlioLogEntry litlioLogEntry);
    public LitlioLogEntry getLitlioLogEntryByID(int id);
    public List<LitlioLogEntry> listLitlioLogEntries(int litlioEntryId);



}
