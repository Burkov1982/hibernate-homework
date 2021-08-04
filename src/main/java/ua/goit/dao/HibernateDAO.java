package ua.goit.dao;

import java.util.List;

public interface HibernateDAO<T> {
    T findById(Integer id) throws Exception;
    void create(T entity) throws Exception;
    void update(T entity) throws Exception;
    void delete(T entity) throws Exception;
    List<T> getAll() throws Exception;
}
