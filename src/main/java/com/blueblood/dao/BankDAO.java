package com.blueblood.dao;

import com.blueblood.dao.impl.IBankDAO;
import com.blueblood.model.Bank;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "bankDAO")
@Transactional
public class BankDAO implements IBankDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Bank save(Bank t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Bank update(Bank t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Bank delete(int id) {
    Bank c = (Bank) sessionFactory.getCurrentSession().load(Bank.class, id);
    sessionFactory.getCurrentSession().delete(c);
    return c;      
    }

    @Override
    public List<Bank> getAll() {
    List<Bank> cList = sessionFactory.getCurrentSession().createCriteria(Bank.class).list();
        return cList;    
    }

    @Override
    public Bank getById(int id) {
    Bank c = (Bank) sessionFactory.getCurrentSession().get(Bank.class, id);
       return c;    
    }

}

