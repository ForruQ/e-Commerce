
package com.blueblood.service;



import com.blueblood.dao.impl.IInvoiceDAO;
import com.blueblood.model.Invoice;
import com.blueblood.service.impl.IInvoiceService;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "invoiceService")
public class InvoiceService implements IInvoiceService{
    
    @Autowired
    IInvoiceDAO invoiceDAO;

    @Override
    public Invoice save(HttpServletRequest request) {
      Map<String, String[]> map = request.getParameterMap();
      double subtotal = Double.parseDouble(request.getParameter("subtotal"));
      int vat = Integer.parseInt(request.getParameter("vat"));
      int dCharge = Integer.parseInt(request.getParameter("dCharge"));
      double grandTotal = Double.parseDouble(request.getParameter("grandTotal"));
      Random random = new Random();
      int orderNo = random.nextInt(100000000);
      Invoice t = new Invoice();
       t.setSubTotal(subtotal);
       t.setVat(vat);
       t.setdCharge(dCharge);
       t.setGrandTotal(grandTotal);
       t.setOrderNo(orderNo);
         return invoiceDAO.save(t);    
    }

    @Override
    public Invoice update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Invoice t = new Invoice();
  
         return invoiceDAO.update(t); }

    @Override
    public Invoice delete(int id) {
       return invoiceDAO.delete(id);
    }

    @Override
    public List<Invoice> getAll() {
        return invoiceDAO.getAll();
       }

    @Override
    public Invoice getById(int id) {
     return invoiceDAO.getById(id);   
    }

   
}
