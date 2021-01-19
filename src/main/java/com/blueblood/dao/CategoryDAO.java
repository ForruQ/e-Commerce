package com.blueblood.dao;

import com.blueblood.dao.impl.ICategoryDAO;
import com.blueblood.model.Category;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "categoryDAO")
@Transactional
public class CategoryDAO implements ICategoryDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Category save(Category t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Category update(Category t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Category delete(int id) {
    Category c = (Category) sessionFactory.getCurrentSession().load(Category.class, id);
    sessionFactory.getCurrentSession().delete(c);
    return c;      
    }

    @Override
    public List<Category> getAll() {
    List<Category> cList = sessionFactory.getCurrentSession().createCriteria(Category.class).list();
        return cList;    
    }

    @Override
    public Category getById(int id) {
    Category c = (Category) sessionFactory.getCurrentSession().get(Category.class, id);
       return c;    
    }

}

