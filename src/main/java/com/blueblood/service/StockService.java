package com.blueblood.service;

import com.blueblood.dao.impl.ICategoryDAO;
import com.blueblood.dao.impl.IStockDAO;
import com.blueblood.model.Stock;
import com.blueblood.service.impl.IStockService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "stockService")
public class StockService implements IStockService {

    @Autowired
    IStockDAO stockDAO;

    @Autowired
    ICategoryDAO categoryDAO;
    
    
     

    //This  method will not be used 
    @Override
    public Stock save(HttpServletRequest request) {
      int pId = Integer.parseInt(request.getParameter("pId"));
      String pName = request.getParameter("pName");
      String pCode = request.getParameter("pCode");
      double pPrice = Double.parseDouble(request.getParameter("pCost"));
      int qty = Integer.parseInt(request.getParameter("qty"));
      double totalCost = Double.parseDouble(request.getParameter("grandTotal"));
      double sPrice = Double.parseDouble(request.getParameter("price"));
      double totalSales = Double.parseDouble(request.getParameter("grandTotal"));
     
      
      Stock p = new Stock();
      p.setpId(pId);
      p.setpName(pName);
      p.setpCode(pCode);
      p.setpPrice(pPrice);
      p.setQty(qty);
      p.setTotalCost(totalCost);
      p.setsPrice(sPrice);
      p.setTotalSales(totalSales);
      return stockDAO.save(p);
   
    }

    @Override
    public Stock update(HttpServletRequest request) {

return null;
    }

    @Override
    public Stock delete(int id) {
        return stockDAO.delete(id);
    }

    @Override
    public List<Stock> getAll() {
        return stockDAO.getAll();
    }

    @Override
    public Stock getById(int id) {
        return stockDAO.getById(id);
    }

}
