package com.blueblood.dao;

import com.blueblood.model.Orders;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.blueblood.dao.impl.IOrdersDAO;
import com.blueblood.model.Stock;
import org.hibernate.Query;

@Repository(value = "ordersDAO")
@Transactional
public class OrdersDAO implements IOrdersDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Orders save(Orders t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Orders update(Orders t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Orders delete(int id) {
    Orders c = (Orders) sessionFactory.getCurrentSession().load(Orders.class, id);
    sessionFactory.getCurrentSession().delete(c);
    return c;      
    }

    @Override
    public List<Orders> getAll() {
    List<Orders> cList = sessionFactory.getCurrentSession().createCriteria(Orders.class).list();
        return cList;    
    }

    @Override
    public Orders getById(int id) {
    Orders c = (Orders) sessionFactory.getCurrentSession().get(Orders.class, id);
       return c;    
    }
    
     @Override
    public List<Orders> getByOrderNo(int orderNo) {
         String hql = "from orders where orderNo = :orderNo";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("orderNo", orderNo);
        List<Orders> oList = query.list();
        return oList;
    }

}

