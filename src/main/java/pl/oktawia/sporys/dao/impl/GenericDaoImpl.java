package pl.oktawia.sporys.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.oktawia.sporys.dao.GenericDao;

import java.io.Serializable;
import java.util.List;


public class GenericDaoImpl<T extends Serializable> implements GenericDao<T> {

    @Autowired
    SessionFactory session;


    @Override
    public T getById(Class<T> t , Long id) {
        return session.openSession().get(t, id);
    }

    @Override
    public void saveOrUpdate(T t) {
        session.openSession().saveOrUpdate(t);
    }

    @Override
    public void delete(T t) {
        session.openSession().delete(t);
    }

    @Override
    public void save(T t) {
        session.openSession().save(t);
    }

    @Override
    public List<T> getAll(Class<T> t) {
        return session.openSession().createCriteria(t).list();
    }
}
