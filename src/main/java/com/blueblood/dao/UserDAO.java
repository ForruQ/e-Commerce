package com.blueblood.dao;

import com.blueblood.dao.impl.IUserDAO;
import com.blueblood.model.User;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "userDAO")
@Transactional
public class UserDAO implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User save(User t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public User update(User t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public User delete(int id) {
    User c = (User) sessionFactory.getCurrentSession().load(User.class, id);
    sessionFactory.getCurrentSession().delete(c);
    return c;      
    }

    @Override
    public List<User> getAll() {
    List<User> cList = sessionFactory.getCurrentSession().createCriteria(User.class).list();
        return cList;    
    }

    @Override
    public User getById(int id) {
    User c = (User) sessionFactory.getCurrentSession().get(User.class, id);
       return c;    
    }

}

