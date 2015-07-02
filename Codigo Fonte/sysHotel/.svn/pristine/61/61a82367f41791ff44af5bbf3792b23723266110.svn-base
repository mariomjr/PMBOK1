package org.sysHotel.dao.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.sysHotel.interfaces.IGenericDao;

/**
 * @author MarioJr
 *
 * @param <T>
 * @param <ID>
 */
@Transactional
@Stateless
public class GenericHibernateDao<T, ID extends Serializable> implements IGenericDao<T>{

	
    @PersistenceContext
	EntityManager entityManager;
 
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public T getById(Long pk) {
        return (T)entityManager.find(getTypeClass(), pk);
    }
 
    public void save(T entity) {
    	Session s = (Session)entityManager.getDelegate();
        s.save(entity);
        s.flush();
    }
 
    public void update(T entity) {
    	Session s = (Session)entityManager.getDelegate();
        s.update(entity);
        s.flush();
    }
 
    public void delete(T entity) {
    	Session s = (Session)entityManager.getDelegate();
        s.delete(entity);
        s.flush();
    }
 
    public List<T> findAll() {
    	Session s = (Session)entityManager.getDelegate();
    	Query q = s.createQuery(("FROM " + getTypeClass().getName()));
    	
        return q.list();
    }
    
    public List<T> findAllAtivos() {
    	Session s = (Session)entityManager.getDelegate();
    	Query q = s.createQuery("FROM " + getTypeClass().getName()+" where ativoInativo = 0");
    	
        return q.list();
    }
    
//    public Query createQuery(String query, Object... parameters) {
//        Query q = entityManager.createQuery(query);
// 
//        for (int i = 1; i <= parameters.length; i++) {
//            q.setParameter(i, parameters[i]);
//        }
         
//        return q;
//    }
 
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }

	public EntityManager getEntityManager() {

		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


    
}
