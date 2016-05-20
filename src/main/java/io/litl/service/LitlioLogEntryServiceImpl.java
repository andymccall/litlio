package io.litl.service;

import io.litl.dao.LitlioLogEntryDAO;
import io.litl.model.LitlioLogEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by andymccall on 20/05/2016.
 */
public class LitlioLogEntryServiceImpl implements LitlioLogEntryService {

    @Autowired
    private LitlioLogEntryDAO litlioLogEntryDAO;

    public void setLitlioLogEntryDAO(LitlioLogEntryDAO litlioLogEntryDAO) {

        litlioLogEntryDAO = litlioLogEntryDAO;
    }

    @Override
    public void addLitlioLogEntry(LitlioLogEntry litlioLogEntry) {

    }

    public LitlioLogEntry getLitlioLogEntryByID(int id) {
        return litlioLogEntryDAO.getLitlioLogEntryByID(id);
    }

    @Override
    @Transactional
    public List<LitlioLogEntry> listLitlioLogEntries(int litlioEntryId) {

        return litlioLogEntryDAO.listLitlioLogEntries(litlioEntryId);

    }
}
