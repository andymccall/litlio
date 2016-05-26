package io.litl.service;

import io.litl.model.LitlioLogEntry;
import java.util.List;

/**
 * Created by andymccall on 20/05/2016.
 */
public interface LitlioLogEntryService {

    public void addLitlioLogEntry(LitlioLogEntry litlioLogEntry);
    public LitlioLogEntry getLitlioLogEntryByID(int id);
    public List<LitlioLogEntry> listLitlioLogEntriesByID(int litlioEntryId);

}
