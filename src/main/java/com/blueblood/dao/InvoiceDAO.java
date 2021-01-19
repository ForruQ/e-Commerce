package com.blueblood.dao;

import com.blueblood.dao.impl.IInvoiceDAO;
import com.blueblood.model.Invoice;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "invoiceDAO")
@Transactional
public class InvoiceDAO implements IInvoiceDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Invoice save(Invoice t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Invoice update(Invoice t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Invoice delete(int id) {
    Invoice c = (Invoice) sessionFactory.getCurrentSession().load(Invoice.class, id);
    sessionFactory.getCurrentSession().delete(c);
    return c;      
    }

    @Override
    public List<Invoice> getAll() {
    List<Invoice> cList = sessionFactory.getCurrentSession().createCriteria(Invoice.class).list();
        return cList;    
    }

    @Override
    public Invoice getById(int id) {
    Invoice c = (Invoice) sessionFactory.getCurrentSession().get(Invoice.class, id);
       return c;    
    }

}

