package com.blueblood.service;

import com.blueblood.dao.impl.ICategoryDAO;
import com.blueblood.dao.impl.IProductDAO;
import com.blueblood.model.Category;
import com.blueblood.model.Product;
import com.blueblood.service.impl.IProductService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "productService")
public class ProductService implements IProductService {

    @Autowired
    IProductDAO productDAO;

    @Autowired
    ICategoryDAO categoryDAO;
    
    
     

    //This  method will not be used 
    @Override
    public Product save(HttpServletRequest request) {
      String pName = request.getParameter("pName");
      String pCode = request.getParameter("pCode");
      //Get Category by category id
      int cId = Integer.parseInt(request.getParameter("cId"));
      Category c = categoryDAO.getById(cId);
     
      String pDesc = request.getParameter("pDesc");
      double pPrice = Double.parseDouble(request.getParameter("pPrice"));
      int discount = Integer.parseInt(request.getParameter("discount"));

      String pPhoto = request.getParameter("pPhoto");
      Product p = new Product();
      p.setpName(pName);
      p.setpCode(pCode);
      p.setcId(c.getcId());
      p.setcName(c.getcName());
      p.setpDesc(pDesc);
      p.setpPrice(pPrice);
      p.setDiscount(discount);
      return productDAO.save(p);
   
    }

    @Override
    public Product update(HttpServletRequest request) {

return null;
    }

    @Override
    public Product delete(int id) {
        return productDAO.delete(id);
    }

    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public Product getById(int id) {
        return productDAO.getById(id);
    }

}
