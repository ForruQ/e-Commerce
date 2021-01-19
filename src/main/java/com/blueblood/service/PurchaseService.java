package com.blueblood.service;

import com.blueblood.dao.impl.ICategoryDAO;
import com.blueblood.dao.impl.IPurchaseDAO;
import com.blueblood.dao.impl.IStockDAO;
import com.blueblood.model.Purchase;
import com.blueblood.model.Stock;
import com.blueblood.service.impl.IPurchaseService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "purchaseService")
public class PurchaseService implements IPurchaseService {

    @Autowired
    IPurchaseDAO purchaseDAO;

    @Autowired
    ICategoryDAO categoryDAO;

    @Autowired
    IStockDAO stockDAO;

    //This  method will not be used 
    @Override
    public Purchase save(HttpServletRequest request) {
        int pId = Integer.parseInt(request.getParameter("pId"));
        String pName = request.getParameter("pName");
        String pCode = request.getParameter("pCode");
        //Get Category by category id
        int cId = Integer.parseInt(request.getParameter("cId"));
        String cName = request.getParameter("cName");
        String pDesc = request.getParameter("pDesc");
        String pPhoto = request.getParameter("pPhoto");
        double pCost = Double.parseDouble(request.getParameter("pCost"));
        int qty = Integer.parseInt(request.getParameter("qty"));
        double total = Double.parseDouble(request.getParameter("total"));
        double vat = Double.parseDouble(request.getParameter("vat"));
        double grandTotal = Double.parseDouble(request.getParameter("grandTotal"));

        Purchase p = new Purchase();
        p.setpId(pId);
        p.setpName(pName);
        p.setpCode(pCode);
        p.setcId(cId);
        p.setcName(cName);
        p.setpDesc(pDesc);
        p.setpPhoto(pPhoto);
        p.setpCost(pCost);
        p.setQty(qty);
        p.setTotal(total);
        p.setVat(vat);
        p.setGrandTotal(grandTotal);
        purchaseDAO.save(p);

        Stock stock = stockDAO.getByProductCode(pCode);
        if (stock != null) {
            System.out.println("Not null");
            Stock s = new Stock();
            s.setId(stock.getId());
             s.setpId(stock.getpId());
             s.setpName(stock.getpName());
             s.setpCode(stock.getpCode());
            s.setpPrice(pCost);
            int lastQty = stock.getQty();
            int updateQty = lastQty + qty;
            s.setQty(updateQty);
            double lastTotal = stock.getTotalCost();
            double updateTotal = lastTotal + grandTotal;
            s.setTotalCost(updateTotal);
            s.setsPrice(stock.getsPrice());
            s.setTotalSales(stock.getTotalSales());
            stockDAO.update(s);
        } else {
            Stock s = new Stock();
           s.setpId(pId);
            s.setpCode(pCode);
            s.setpName(pName);
            s.setpPrice(pCost);
            s.setQty(qty);
            s.setTotalCost(grandTotal);
            s.setTotalSales(0D);
            stockDAO.save(s);
            System.out.println("null");
        }  
       
        return p;
    }

    @Override
    public Purchase update(HttpServletRequest request) {

        return null;
    }

    @Override
    public Purchase delete(int id) {
        return purchaseDAO.delete(id);
    }

    @Override
    public List<Purchase> getAll() {
        return purchaseDAO.getAll();
    }

    @Override
    public Purchase getById(int id) {
        return purchaseDAO.getById(id);
    }

}
