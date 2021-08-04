package ua.goit.service;

public interface HibernateService<T> {
    String create(T entity);
    String delete(T entity);
    String update(T entity);
    String findById(Integer id);
    String getAll();
}
