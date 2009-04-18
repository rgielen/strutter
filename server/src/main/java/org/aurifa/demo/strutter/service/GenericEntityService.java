package org.aurifa.demo.strutter.service;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.aurifa.demo.strutter.helper.SessionProvider;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class GenericEntityService<T, I extends Serializable> {

    protected abstract Class<T> entityClass();

    @Resource
    SessionProvider sessionProvider;

    public Session getCurrentSession() {
        return sessionProvider.getCurrentSession();
    }

    public T get( I id ) {
        return (T) getCurrentSession().get(entityClass(), id);
    }

    public T load( I id ) {
        return (T) getCurrentSession().load(entityClass(), id);
    }

    public <M extends T> I save( M modelObject ) {
        return (I) getCurrentSession().save(modelObject);
    }

    public <M extends T> M update( M modelObject ) {
        getCurrentSession().update(modelObject);
        return modelObject;
    }

    public <M extends T, R extends T> R merge( M modelObject ) {
        return (R) getCurrentSession().merge(modelObject);
    }

    public <M extends T> M saveOrUpdate( M modelObject ) {
        getCurrentSession().saveOrUpdate(modelObject);
        return modelObject;
    }

    public <M extends T> void delete( M modelObject ) throws DataAccessException {
        getCurrentSession().delete(modelObject);
    }

    public Query createQuery( String queryString ) {
        return getCurrentSession().createQuery(queryString);
    }

    public Query getNamedQuery( String queryName ) {
        return getCurrentSession().getNamedQuery(queryName);
    }

    public void flush() {
        getCurrentSession().flush();
    }

    public Criteria createCriteria() {
        return getCurrentSession().createCriteria(entityClass());
    }

    public <M extends T> List<M> list( Criteria criteria ) {
        if (criteria != null) {
            return criteria.list();
        } else {
            return Collections.emptyList();
        }
    }

    public <M extends T> List<M> list( Query query ) {
        if (query != null) {
            return query.list();
        } else {
            return Collections.emptyList();
        }
    }

    public <M extends T> List<M> listForQuery( String queryString ) {
        return list(createQuery(queryString));
    }

    public <M extends T> List<M> listForNamedQuery( String queryName ) {
        return list(getNamedQuery(queryName));
    }

    public <M extends T> List<M> findAll() {
        return list(createCriteria());
    }


    public <M> M first( List<M> list ) {
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
