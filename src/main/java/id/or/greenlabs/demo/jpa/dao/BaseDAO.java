package id.or.greenlabs.demo.jpa.dao;

import java.util.Collection;

/**
 * @Author krissadewo
 * @Date 16/01/18
 **/
public interface BaseDAO<T> {

    T save(final T entity);

    T update(final T entity);

    T delete(final T entity);

    T findById(final Long id);

    Collection<T> find(T param, int offset, int limit);

    Long count(T param);
}
