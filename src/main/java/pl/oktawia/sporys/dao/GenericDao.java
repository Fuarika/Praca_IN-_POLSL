package pl.oktawia.sporys.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T extends Serializable> {

    T getById(Class<T> t, Long id);
    List<T> getAll(Class<T> t);
    void saveOrUpdate(T t);
    void save(T t);
    void delete(T t);
}
