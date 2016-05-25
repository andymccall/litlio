package io.litl.service;

import io.litl.dao.LitlioEntryDAO;
import io.litl.model.LitlioEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.security.SecureRandom;

/**
 * Created by andym on 10/03/2016.
 */
@Service("litlioEntryService")
@Transactional
public class LitlioEntryServiceImpl implements LitlioEntryService {

    @Autowired
    private LitlioEntryDAO litlioEntryDAO;

    public void setLitlioEntryDAO(LitlioEntryDAO litlioEntryDAO) {

        litlioEntryDAO = litlioEntryDAO;
    }

    @Override
    @Transactional
    public LitlioEntry addLitlioEntry(LitlioEntry litlioEntry) {
        if (litlioEntry != null) {
            litlioEntry.setShortURL(createShortURL());

            litlioEntryDAO.addLitlioEntry(litlioEntry);

            return litlioEntry;

        } else {
            throw new RuntimeException("litlioEntry cannot be null!");
        }

    }

    private String createShortURL() {
        String characterSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder shortURL = new StringBuilder(6);

        for( int i = 0; i < 6; i++ ) {
            shortURL.append(characterSet.charAt(rnd.nextInt(characterSet.length())));
        }

        return shortURL.toString();
    }

    @Override
    @Transactional
    public LitlioEntry getLitlioEntryByID(int id) {

        return litlioEntryDAO.getLitlioEntryByID(id);
    }

    @Override
    @Transactional
    public LitlioEntry getLitlioEntryByShortURL(String shortURL) {
        return litlioEntryDAO.getLitlioEntryByShortURL(shortURL);

    }

    @Override
    @Transactional
    public List<LitlioEntry> listLitlioEntries() {

        return litlioEntryDAO.listLitlioEntries();
    }

}
