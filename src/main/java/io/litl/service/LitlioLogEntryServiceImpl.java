package io.litl.service;

import io.litl.dao.LitlioLogEntryDAO;
import io.litl.model.LitlioLogEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by andymccall on 20/05/2016.
 */
@Service("litlioLogEntryService")
@Transactional
public class LitlioLogEntryServiceImpl implements LitlioLogEntryService {

    @Autowired
    private LitlioLogEntryDAO litlioLogEntryDAO;

    public void setLitlioLogEntryDAO(LitlioLogEntryDAO litlioLogEntryDAO) {

        litlioLogEntryDAO = litlioLogEntryDAO;
    }

    @Override
    @Transactional
    public void addLitlioLogEntry(LitlioLogEntry litlioLogEntry) {
        if (litlioLogEntry != null) {

            litlioLogEntryDAO.addLitlioLogEntry(litlioLogEntry);

        } else {
            throw new RuntimeException("litlioLogEntry cannot be null!");
        }


    }

    public LitlioLogEntry getLitlioLogEntryByID(int id) {
        return litlioLogEntryDAO.getLitlioLogEntryByID(id);
    }

    @Override
    @Transactional
    public List<LitlioLogEntry> listLitlioLogEntriesByID(int litlioEntryId) {

        return litlioLogEntryDAO.listLitlioLogEntriesByID(litlioEntryId);

    }
}
