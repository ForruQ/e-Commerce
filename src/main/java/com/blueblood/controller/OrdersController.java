
package com.blueblood.controller;




import com.blueblood.model.Orders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.blueblood.service.impl.IOrdersService;
import com.blueblood.controller.impl.IOrdersController;
import com.blueblood.model.Invoice;
import com.blueblood.service.InvoiceService;
import com.blueblood.service.impl.IInvoiceService;
import org.springframework.ui.ModelMap;


@Controller
@RequestMapping(value = "orders")
public class OrdersController implements IOrdersController{
    @Autowired
    IOrdersService ordersService;
    @Autowired
    IInvoiceService invoiceService;
    
    

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        
        return new ModelAndView("orders/create");
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
      Orders t = ordersService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("/orders/register", "map", map);
       
    }

    @Override
        @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Orders c = ordersService.getById(id);
        c.setoId(id);
       return new ModelAndView("orders/update", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Orders c =  ordersService.update(request);
        return new ModelAndView("orders/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
    Orders c = ordersService.delete(id);
       return new ModelAndView("redirect:/orders/view");    
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
    Map<String, Object> map = new HashMap<String, Object>();
    List<Orders> cList = ordersService.getAll();
    map.put("cList", cList);
    return new ModelAndView("orders/view", "map", map);
    }

      @RequestMapping(value = "/details", method = RequestMethod.GET)
    public ModelAndView details() {
    Map<String, Object> map = new HashMap<String, Object>();
    List<Invoice> iList = invoiceService.getAll();
    map.put("iList", iList);
    return new ModelAndView("orders/view", "map", map);
    }
    
     @RequestMapping(value = "/pDetails/{orderNo}", method = RequestMethod.GET)
    public ModelAndView getByOrderNo(@PathVariable("orderNo") int orderNo){
        Map<String, Object> map = new HashMap<String, Object>();
       List<Orders> oList =  ordersService.getByOrderNo(orderNo);
       map.put("oList", oList);
       return new ModelAndView("orders/pDetails", "map", map);  
    }
    
    
}
