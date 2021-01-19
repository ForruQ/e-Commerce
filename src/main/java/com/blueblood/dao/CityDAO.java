
package com.blueblood.dao;

import com.blueblood.dao.impl.ICityDAO;
import com.blueblood.model.City;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "cityDAO")
@Transactional
public class CityDAO implements ICityDAO{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public City save(City t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public City update(City t) {
    sessionFactory.getCurrentSession().saveOrUpdate(t);
    return t;
    }

    @Override
    public City delete(int id) {
    City city = (City) sessionFactory.getCurrentSession().load(City.class, id);
    sessionFactory.getCurrentSession().delete(city);
    return city;    
    }

    @Override
    public List<City> getAll() {
        List<City> cityList = sessionFactory.getCurrentSession().createCriteria(City.class).list();
        return cityList;
    }

    @Override
    public City getById(int id) {
       City city = (City) sessionFactory.getCurrentSession().get(City.class, id);
       return city;
    }

//    @Override
//    public City getByCityId(int cid) {
//        City
//    }
    
}
