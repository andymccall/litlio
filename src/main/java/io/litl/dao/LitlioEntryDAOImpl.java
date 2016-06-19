package io.litl.dao;

import io.litl.model.LitlioEntry;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

import static io.litl.LitlioApplication.count;

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

    public LitlioEntry getLitlioEntryByAliasURL(String aliasURL) {

        LitlioEntry litlioEntry;

        // Grab the LitlioEntry
        Criteria criteria = getSession().createCriteria(LitlioEntry.class);
        criteria.add(Restrictions.eq("aliasURL",aliasURL));
        litlioEntry = (LitlioEntry) criteria.uniqueResult();

        return litlioEntry;
    }

    public Long getLitlioEntryCount() {

        return (Long) getSession().createCriteria(LitlioEntry.class).setProjection(Projections.rowCount()).uniqueResult();

    }

    public Boolean ifExists(String aliasURL) {

        return getSession().createCriteria(LitlioEntry.class)
                .add(Restrictions.eq("aliasURL", aliasURL))
                .setProjection(Projections.property("aliasURL"))
                .uniqueResult() != null;
    }


}
