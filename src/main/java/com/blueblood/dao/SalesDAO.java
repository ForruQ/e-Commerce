package com.blueblood.dao;


import com.blueblood.dao.impl.ISalesDAO;
import com.blueblood.model.Sales;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "salesDAO")
@Transactional
public class SalesDAO implements ISalesDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Sales save(Sales t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Sales update(Sales t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Sales delete(int id) {
    Sales c = (Sales) sessionFactory.getCurrentSession().load(Sales.class, id);
    sessionFactory.getCurrentSession().delete(c);
    return c;      
    }

    @Override
    public List<Sales> getAll() {
    List<Sales> cList = sessionFactory.getCurrentSession().createCriteria(Sales.class).list();
        return cList;    
    }

    @Override
    public Sales getById(int id) {
    Sales c = (Sales) sessionFactory.getCurrentSession().get(Sales.class, id);
       return c;    
    }

}

