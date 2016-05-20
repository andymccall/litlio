package io.litl.dao;

import io.litl.model.LitlioEntry;
import io.litl.model.LitlioLogEntry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by andymccall on 22/04/2016.
 */
public abstract class AbstractDAO {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void persist(LitlioEntry entity) {
        getSession().persist(entity);
    }
    public void persist(LitlioLogEntry entity) {
        getSession().persist(entity);
    }


    public void delete(Object entity) {
        getSession().delete(entity);
    }

}
