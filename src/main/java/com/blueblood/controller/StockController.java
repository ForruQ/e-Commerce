package com.blueblood.controller;

import com.blueblood.controller.impl.IStockController;
import com.blueblood.dao.impl.ICategoryDAO;
import com.blueblood.dao.impl.IStockDAO;
import com.blueblood.model.Category;
import com.blueblood.model.Product;
import com.blueblood.model.Stock;
import com.blueblood.service.StockService;
import com.blueblood.service.impl.ICategoryService;
import com.blueblood.service.impl.IProductService;
import com.blueblood.service.impl.IStockService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller

@RequestMapping(value = "stock")
public class StockController implements IStockController {

    @Autowired
    IStockService stockService;
    @Autowired
    IStockDAO stockDAO;
    @Autowired
    IProductService productService;




    @Override
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
//        Map<String, Object> map = new HashMap<String, Object>();
//        List<Category> catList = categoryService.getAll();
//        map.put("catList", catList);
        return new ModelAndView("stock/create");
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Stock t = stockService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("stock/create", "map", map);

    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Stock c = stockService.getById(id);
        c.setpId(id);
        return new ModelAndView("stock/create", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Stock c = stockService.update(request);
        return new ModelAndView("stock/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        Stock c = stockService.delete(id);
        return new ModelAndView("redirect:/stock/view");
    }

    //To View
    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Stock> pList = stockService.getAll();
        map.put("pList", pList);
        return new ModelAndView("stock/view", "map", map);
    }

    //To show stock in Cart
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ModelAndView category() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Stock> pList = stockService.getAll();
        map.put("pList", pList);
        return new ModelAndView("home/category", "map", map);
    }

   //To return update page
   @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("stock/update");
    }
    
    //method for search product
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(HttpServletRequest request) {
        int pId = Integer.parseInt(request.getParameter("pId"));
        Product product = productService.getById(pId);
        product.setpId(pId);
        return new ModelAndView("stock/create", "product", product);
    }
    

}
