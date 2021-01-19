
package com.blueblood.controller;

import com.blueblood.model.Basket;
import com.blueblood.model.City;
import com.blueblood.model.Country;
import com.blueblood.model.Product;
import com.blueblood.service.impl.IBasketService;
import com.blueblood.service.impl.ICityService;
import com.blueblood.service.impl.ICountryService;
import com.blueblood.service.impl.IProductService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "home")
public class HomeController {
    
    @Autowired
    IBasketService basketService;
    @Autowired
    IProductService productService;
    @Autowired
    ICountryService countryService;
    @Autowired 
    ICityService cityService;
    
    @RequestMapping(value = "/home")
    public String home(){
        return "home/index";
    }
     @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public ModelAndView basket() {
    Map<String, Object> map = new HashMap<String, Object>();
    List<Basket> bList = basketService.getAll();
    map.put("bList", bList);
    return new ModelAndView("home/basket", "map", map);
    }
     @RequestMapping(value = "/blog")
    public String blog(){
        return "home/blog";
    }
     @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ModelAndView category() {
    Map<String, Object> map = new HashMap<String, Object>();
    List<Product> pList = productService.getAll();
    map.put("pList", pList);
    return new ModelAndView("home/category", "map", map);
    }
     @RequestMapping(value = "/categry-full")
    public String cat2(){
        return "home/categry-full";
    }
     @RequestMapping(value = "/category-right")
    public String cat3(){
        return "home/category-right";
    }
    
     @RequestMapping(value = "/checkout1")
    public ModelAndView checkout1(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Country> countries = countryService.getAll();
        List<City> cities = cityService.getAll();
        map.put("countries", countries);
        map.put("cities", cities);
        return new ModelAndView("home/checkout1", "map", map);
    }
     @RequestMapping(value = "/checkout2")
    public String checkout2(){
        return "home/checkout2";
    }
     @RequestMapping(value = "/checkout3")
    public String checkout3(){
        return "home/checkout3";
    }
     @RequestMapping(value = "/checkout4")
    public String checkout4(){
        return "home/checkout4";
    }
    @RequestMapping(value = "/checkout5")
    public String checkout5(){
        return "home/checkout5";
    }
     @RequestMapping(value = "/contact")
    public String contact(){
        return "home/contact";
    }
     @RequestMapping(value = "/customer-account")
    public String customer(){
        return "home/customer-account";
    }
     @RequestMapping(value = "/customer-order")
    public String order(){
        return "home/customer-order";
    }
     @RequestMapping(value = "/customer-orders")
    public String orders(){
        return "home/customer-orders";
    }
    
     @RequestMapping(value = "/customer-wishlist")
    public String wishlist(){
        return "home/customer-wishlis";
    }
     @RequestMapping(value = "/details")
    public String detailsl(){
        return "home/details";
    }
     @RequestMapping(value = "/faq")
    public String faq(){
        return "home/faq";
    }
     @RequestMapping(value = "/post")
    public String post(){
        return "home/post";
    }
     @RequestMapping(value = "/reg")
    public String reg(){
        return "home/registration";
    }
    
}
