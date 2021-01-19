package com.blueblood.service;

import com.blueblood.dao.impl.IInvoiceDAO;
import com.blueblood.model.Orders;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blueblood.dao.impl.IOrdersDAO;
import com.blueblood.model.Invoice;
import com.blueblood.service.impl.IOrdersService;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

@Service(value = "ordersService")
public class OrdersService implements IOrdersService {

    @Autowired
    IOrdersDAO ordersDAO;
    @Autowired
    IInvoiceDAO invoiceDAO;

    @Override
    public Orders save(HttpServletRequest request) {

        Map<String, String[]> map = request.getParameterMap();
        String[] ids = map.get("ids[]");
        String[] pId = (String[]) map.get("pId[]");
        String[] pName = (String[]) map.get("pName[]");
        String[] pCode = (String[]) map.get("pCode[]");
        String[] pPhoto = (String[]) map.get("pPhoto[]");
        String[] pPrice = (String[]) map.get("pPrice[]");
        String[] discount = (String[]) map.get("discount[]");
        String[] qty = (String[]) map.get("qty[]");
        String[] total = (String[]) map.get("total[]");
        String[] cId = (String[]) map.get("cId[]");
        
        // For invoice
         double subtotal = Double.parseDouble(request.getParameter("subtotal"));
      int vat = Integer.parseInt(request.getParameter("vat"));
      int dCharge = Integer.parseInt(request.getParameter("dCharge"));
      double grandTotal = Double.parseDouble(request.getParameter("grandTotal"));
      
        //generatinng random value for order no
      Random random = new Random();
      int orderNo = random.nextInt(100000000);
      LocalDate d = LocalDate.now();
      String orderDate = d.toString();
      
      Invoice invoice = new Invoice();
       invoice.setSubTotal(subtotal);
       invoice.setVat(vat);
       invoice.setdCharge(dCharge);
       invoice.setGrandTotal(grandTotal);
       invoice.setOrderNo(orderNo);
       invoice.setOrderDate(orderDate);
      invoiceDAO.save(invoice);    

        Orders t = new Orders();

        for (int i = 0; i < ids.length; i++) {
            t.setpId(Integer.parseInt(pId[i]));
            t.setpName(pName[i]);
            t.setpCode(pCode[i]);
            t.setpPhoto(pPhoto[i]);
            t.setpPrice(Double.parseDouble(pPrice[i]));
            t.setDiscount(Integer.parseInt(discount[i]));
            t.setQty(Integer.parseInt(qty[i]));
            t.setTotal(Double.parseDouble(total[i]));
            t.setcId(Integer.parseInt(cId[i]));
            t.setOrderNo(orderNo);

            ordersDAO.save(t);
        }
        return t;

    }

    @Override
    public Orders update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Orders t = new Orders();

        return ordersDAO.update(t);
    }

    @Override
    public Orders delete(int id) {
        return ordersDAO.delete(id);
    }

    @Override
    public List<Orders> getAll() {
        return ordersDAO.getAll();
    }

    @Override
    public Orders getById(int id) {
        return ordersDAO.getById(id);
    }

    @Override
    public List<Orders> getByOrderNo(int orderNo) {
    return ordersDAO.getByOrderNo(orderNo);
    }

}
