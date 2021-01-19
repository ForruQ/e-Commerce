package com.blueblood.controller;

import com.blueblood.controller.impl.IBasketController;
import com.blueblood.dao.impl.IBasketDAO;
import com.blueblood.model.Basket;
import com.blueblood.model.Basket;
import com.blueblood.model.Product;
import com.blueblood.service.impl.IBasketService;
import com.blueblood.service.impl.IBasketService;
import com.blueblood.service.impl.IProductService;
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

@RequestMapping(value = "basket")
public class BasketController implements IBasketController {

    @Autowired
    IBasketService basketService;
    @Autowired
    IBasketDAO basketDAO;
    @Autowired
    IProductService productService;




    @Override
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
//        Map<String, Object> map = new HashMap<String, Object>();
//        List<Category> catList = categoryService.getAll();
//        map.put("catList", catList);
        return new ModelAndView("basket/create");
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Basket t = basketService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("redirect:/home/category", "map", map);

    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Basket c = basketService.getById(id);
        c.setpId(id);
        return new ModelAndView("basket/create", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Basket c = basketService.update(request);
        return new ModelAndView("basket/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        Basket c = basketService.delete(id);
        return new ModelAndView("redirect:/basket/view");
    }

    //To View
    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Basket> pList = basketService.getAll();
        map.put("pList", pList);
        return new ModelAndView("basket/view", "map", map);
    }

    //To show basket in Cart
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ModelAndView category() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Basket> pList = basketService.getAll();
        map.put("pList", pList);
        return new ModelAndView("home/category", "map", map);
    }

   //To return update page
   @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("basket/update");
    }
    
    //method for search basket
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(HttpServletRequest request) {
        int pId = Integer.parseInt(request.getParameter("pId"));
        Basket basket = basketService.getById(pId);
        //basket.se(pId);
        return new ModelAndView("basket/create", "basket", basket);
    }
    
     @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView cart() {
       Map<String, Object> map = new HashMap<String, Object>();
        List<Basket> bList = basketService.getAll();
        map.put("bList", bList);
        return new ModelAndView("cart/cart", "map", map);
    }

}
