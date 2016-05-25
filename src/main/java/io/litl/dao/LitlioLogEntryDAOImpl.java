package io.litl.dao;

import io.litl.model.LitlioLogEntry;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by andymccall on 19/05/2016.
 */
@Repository("litlioLogEntryDao")
public class LitlioLogEntryDAOImpl extends AbstractDAO implements LitlioLogEntryDAO {

    public void addLitlioLogEntry(LitlioLogEntry litlioLogEntry) {
        System.out.println(litlioLogEntry.toString());
        persist(litlioLogEntry);
    }

    public LitlioLogEntry getLitlioLogEntryByID(int id) {
        Criteria criteria = getSession().createCriteria(LitlioLogEntry.class);
        criteria.add(Restrictions.eq("id",id));
        return (LitlioLogEntry) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<LitlioLogEntry> listLitlioLogEntries(int litlioEntryId) {
        Criteria criteria = getSession().createCriteria(LitlioLogEntry.class);
        return (List<LitlioLogEntry>) criteria.list();
    }

}
