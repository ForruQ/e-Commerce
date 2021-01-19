package com.blueblood.service;

import com.blueblood.dao.impl.ICategoryDAO;
import com.blueblood.dao.impl.IBasketDAO;
import com.blueblood.model.Basket;
import com.blueblood.service.impl.IBasketService;
import java.util.List;

import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "basketService")
public class BasketService implements IBasketService {

    @Autowired
    IBasketDAO basketDAO;

    @Autowired
    ICategoryDAO categoryDAO;

    @Autowired
    ServletContext servletContext;

    //For multipart data
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Basket save(HttpServletRequest request) {
        int pId = Integer.parseInt(request.getParameter("pId"));
        String pName = request.getParameter("pName");
        String pCode = request.getParameter("pCode");
        String pPhoto = request.getParameter("pPhoto");
        double pPrice = Double.parseDouble(request.getParameter("pPrice"));
        int discount = Integer.parseInt(request.getParameter("discount"));
        int qty = 1;
        double  total = (pPrice - ((pPrice * discount)/100));
        
        Basket b = new Basket();
        b.setpId(pId);
        b.setpName(pName);
        b.setpCode(pCode);
        b.setpPrice(pPrice);
        b.setpPhoto(pPhoto);
        b.setQty(qty);
        b.setDiscount(discount);
        b.setTotal(total);
        return basketDAO.save(b);
    }

    @Override
    public Basket update(HttpServletRequest request) {
//        Map<String, String[]> map = request.getParameterMap();
//        int i = Integer.parseInt(map.get("category")[0]);
//        Category c = categoryDAO.getById(i);
//
//        Basket t = new Basket();
//        t.setpPrice(Integer.parseInt(map.get("pId")[0]));
//        t.setpName(map.get("pName")[0]);
//        t.setpDescription(map.get("pDescription")[0]);
//        t.setpPhoto(map.get("pPhoto")[0]);
//        t.setpPrice(Integer.parseInt(map.get("pPrice")[0]));
//        t.setpDiscount(Integer.parseInt(map.get("pDiscount")[0]));
//        t.setpQuantity(Integer.parseInt(map.get("pQuantity")[0]));
//
//        return basketDAO.update(t);
        return null;
    }

    @Override
    public Basket delete(int id) {
        return basketDAO.delete(id);
    }

    @Override
    public List<Basket> getAll() {
        return basketDAO.getAll();
    }

    @Override
    public Basket getById(int id) {
        return basketDAO.getById(id);
    }

}
