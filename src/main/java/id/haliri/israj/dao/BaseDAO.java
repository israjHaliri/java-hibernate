package id.haliri.israj.dao;

import java.util.Collection;

public interface BaseDAO<T> {

    T save(final T entity);

    T update(final T entity);

    T delete(final T entity);

    T findById(final Long id);

    Collection<T> find(T param, int offset, int limit);

    Long count(T param);
}
