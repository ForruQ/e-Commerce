package com.blueblood.dao;

import com.blueblood.dao.impl.ITemporaryTableDAO;
import com.blueblood.model.TemporaryTable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "temporaryTableDAO")
@Transactional
public class TemporaryTableDAO implements ITemporaryTableDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public TemporaryTable save(TemporaryTable t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public TemporaryTable update(TemporaryTable t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public TemporaryTable delete(int id) {
    TemporaryTable c = (TemporaryTable) sessionFactory.getCurrentSession().load(TemporaryTable.class, id);
    sessionFactory.getCurrentSession().delete(c);
    return c;      
    }

    @Override
    public List<TemporaryTable> getAll() {
    List<TemporaryTable> cList = sessionFactory.getCurrentSession().createCriteria(TemporaryTable.class).list();
        return cList;    
    }

    @Override
    public TemporaryTable getById(int id) {
    TemporaryTable c = (TemporaryTable) sessionFactory.getCurrentSession().get(TemporaryTable.class, id);
       return c;    
    }

}

