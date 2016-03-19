package io.litl.dao;

import io.litl.model.LitlioEntry;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by andym on 10/03/2016.
 */
@Repository
public class LitlioEntryDAOImpl extends AbstractDAO implements LitlioEntryDAO {

    @Override
    public void addLitlioEntry(LitlioEntry litlioEntry) {

    }

    @Override
    public LitlioEntry getLitloEntryByID(int id) {
        return null;
    }

    @Override
    public List<LitlioEntry> listLitlioEntries() {
        return null;
    }
}
