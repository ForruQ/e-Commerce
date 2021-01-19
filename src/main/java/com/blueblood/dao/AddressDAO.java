package com.blueblood.dao;

import com.blueblood.dao.impl.IAddressDAO;
import com.blueblood.model.Address;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "addressDAO")
@Transactional
public class AddressDAO implements IAddressDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Address save(Address t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Address update(Address t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Address delete(int id) {
    Address c = (Address) sessionFactory.getCurrentSession().load(Address.class, id);
    sessionFactory.getCurrentSession().delete(c);
    return c;      
    }

    @Override
    public List<Address> getAll() {
    List<Address> cList = sessionFactory.getCurrentSession().createCriteria(Address.class).list();
        return cList;    
    }

    @Override
    public Address getById(int id) {
    Address c = (Address) sessionFactory.getCurrentSession().get(Address.class, id);
       return c;    
    }

    @Override
    public Address getByCid(int cId) {
    String hql = "from address where cId = :cId";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("cId", cId);
        Address s = (Address) query.uniqueResult();
        if(s != null){
            return s;
        } else {
            return null;
        }    
    
    }

  

}

