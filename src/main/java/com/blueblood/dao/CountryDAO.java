package com.blueblood.dao;

import com.blueblood.dao.impl.ICountryDAO;
import com.blueblood.model.Country;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "countryDAO")
@Transactional
public class CountryDAO implements ICountryDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Country save(Country t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Country update(Country t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Country delete(int id) {
    Country c = (Country) sessionFactory.getCurrentSession().load(Country.class, id);
    sessionFactory.getCurrentSession().delete(c);
    return c;      
    }

    @Override
    public List<Country> getAll() {
    List<Country> cList = sessionFactory.getCurrentSession().createCriteria(Country.class).list();
        return cList;    
    }

    @Override
    public Country getById(int id) {
    Country c = (Country) sessionFactory.getCurrentSession().get(Country.class, id);
       return c;    
    }

}

