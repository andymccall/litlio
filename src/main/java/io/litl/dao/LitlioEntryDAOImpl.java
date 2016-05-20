package io.litl.dao;

import io.litl.model.LitlioEntry;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by andym on 10/03/2016.
 */
@Repository("litlioEntryDao")
public class LitlioEntryDAOImpl extends AbstractDAO implements LitlioEntryDAO {

    public void addLitlioEntry(LitlioEntry litlioEntry) {
        persist(litlioEntry);
    }

    public LitlioEntry getLitlioEntryByID(int id) {
        Criteria criteria = getSession().createCriteria(LitlioEntry.class);
        criteria.add(Restrictions.eq("id",id));
        return (LitlioEntry) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<LitlioEntry> listLitlioEntries() {
        Criteria criteria = getSession().createCriteria(LitlioEntry.class);
        return (List<LitlioEntry>) criteria.list();
    }

    public LitlioEntry getLitlioEntryByShortURL(String shortURL) {

        LitlioEntry litlioEntry;

        // Grab the LitlioEntry
        Criteria criteria = getSession().createCriteria(LitlioEntry.class);
        criteria.add(Restrictions.eq("shortURL",shortURL));
        litlioEntry = (LitlioEntry) criteria.uniqueResult();

        // Increment the hitcounter and save before returning
        litlioEntry.incrementHitCount();
        persist(litlioEntry);

        return litlioEntry;
    }


}
