package com.blueblood.dao;


import com.blueblood.dao.impl.IProductDAO;
import com.blueblood.model.Product;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "productDAO")
@Transactional
public class ProductDAO implements IProductDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Product save(Product t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Product update(Product t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Product delete(int id) {
    Product c = (Product) sessionFactory.getCurrentSession().load(Product.class, id);
    sessionFactory.getCurrentSession().delete(c);
    return c;      
    }

    @Override
    public List<Product> getAll() {
    List<Product> cList = sessionFactory.getCurrentSession().createCriteria(Product.class).list();
        return cList;    
    }

    @Override
    public Product getById(int id) {
    Product c = (Product) sessionFactory.getCurrentSession().get(Product.class, id);
       return c;    
    }

}

