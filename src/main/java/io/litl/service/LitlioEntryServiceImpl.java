package io.litl.service;

import io.litl.model.LitlioEntry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.security.SecureRandom;
import java.math.BigInteger;

/**
 * Created by andym on 10/03/2016.
 */
@Service
public class LitlioEntryServiceImpl implements LitlioEntryService {

    private Map<Integer,LitlioEntry> litlioEntries;

    public LitlioEntryServiceImpl() {

        loadLitlioEntries();

    }

    @Override
    public LitlioEntry addLitlioEntry(LitlioEntry litlioEntry) {
        if (litlioEntry != null) {
            litlioEntry.setId(getNextKey());
            litlioEntry.setHitCount(0);
            litlioEntry.setShortURL(createShortURL());

            System.out.println(litlioEntry.toString());

            litlioEntries.put(litlioEntry.getId(), litlioEntry);

            return litlioEntry;

        } else {
            throw new RuntimeException("litlioEntry cannot be null!");
        }

    }

    // Return the next key in the hashmap
    private Integer getNextKey() {
        return Collections.max(litlioEntries.keySet()) + 1;
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
    public LitlioEntry getLitlioEntryByID(int id) {
        return litlioEntries.get(id);
    }

    @Override
    public LitlioEntry getLitlioEntryByShortURL(String shortURL) {

        // TODO : Replace code when Hibernate is working
        for (LitlioEntry entry : listLitlioEntries()) {
            if (entry.getShortURL().equals(shortURL)) {
                entry.incrementHitCount();
                return entry;
            }
        }

        // Return an empty entry for now
        return new LitlioEntry();

    }

    @Override
    public List<LitlioEntry> listLitlioEntries() {
        return new ArrayList<>(litlioEntries.values());
    }

    private void loadLitlioEntries(){
        litlioEntries = new HashMap<>();

        LitlioEntry litlioEntry1 = new LitlioEntry();
        litlioEntry1.setId(1);
        litlioEntry1.setLongURL("http://www.bbc.co.uk/");
        litlioEntry1.setShortURL("HjkI8");
        litlioEntry1.setHitCount(0);

        litlioEntries.put(1, litlioEntry1);

        LitlioEntry litlioEntry2 = new LitlioEntry();
        litlioEntry2.setId(2);
        litlioEntry2.setLongURL("http://www.amazon.co.uk/");
        litlioEntry2.setShortURL("Jku78");
        litlioEntry2.setHitCount(0);

        litlioEntries.put(2, litlioEntry2);

        LitlioEntry litlioEntry3 = new LitlioEntry();
        litlioEntry3.setId(3);
        litlioEntry3.setLongURL("http://www.slashdot.org/");
        litlioEntry3.setShortURL("T54Fo");
        litlioEntry3.setHitCount(0);


        litlioEntries.put(3, litlioEntry3);

        LitlioEntry litlioEntry4 = new LitlioEntry();
        litlioEntry4.setId(4);
        litlioEntry4.setLongURL("http://www.kotaku.com/");
        litlioEntry4.setShortURL("Kuy6r");
        litlioEntry4.setHitCount(0);


        litlioEntries.put(4, litlioEntry4);

        LitlioEntry litlioEntry5 = new LitlioEntry();
        litlioEntry5.setId(5);
        litlioEntry5.setLongURL("http://www.spring.io/");
        litlioEntry5.setShortURL("OP93d");
        litlioEntry5.setHitCount(0);

        litlioEntries.put(5, litlioEntry5);
    }
}
