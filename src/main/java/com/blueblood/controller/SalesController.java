package com.blueblood.controller;

import com.blueblood.controller.impl.ISalesController;
import com.blueblood.dao.impl.ICategoryDAO;
import com.blueblood.dao.impl.ISalesDAO;
import com.blueblood.model.Category;
import com.blueblood.model.Product;
import com.blueblood.model.Sales;
import com.blueblood.service.impl.IProductService;
import com.blueblood.service.impl.ISalesService;
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

@Controller

@RequestMapping(value = "sales")
public class SalesController implements ISalesController {

    @Autowired
    ISalesService salesService;
    @Autowired
    ISalesDAO salesDAO;
    @Autowired
    IProductService productService;




    @Override
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
//        Map<String, Object> map = new HashMap<String, Object>();
//        List<Category> catList = categoryService.getAll();
//        map.put("catList", catList);
        return new ModelAndView("sales/create");
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Sales t = salesService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("sales/create", "map", map);

    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Sales c = salesService.getById(id);
        c.setpId(id);
        return new ModelAndView("sales/create", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Sales c = salesService.update(request);
        return new ModelAndView("sales/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        Sales c = salesService.delete(id);
        return new ModelAndView("redirect:/sales/view");
    }

    //To View
    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Sales> pList = salesService.getAll();
        map.put("pList", pList);
        return new ModelAndView("sales/view", "map", map);
    }

    //To show sales in Cart
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ModelAndView category() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Sales> pList = salesService.getAll();
        map.put("pList", pList);
        return new ModelAndView("home/category", "map", map);
    }

   //To return update page
   @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("sales/update");
    }
    
    //method for search product
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(HttpServletRequest request) {
        int pId = Integer.parseInt(request.getParameter("pId"));
        Product product = productService.getById(pId);
        product.setpId(pId);
        return new ModelAndView("sales/create", "product", product);
    }
    

}
