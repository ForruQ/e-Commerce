package com.blueblood.controller;

import com.blueblood.controller.impl.IProductController;
import com.blueblood.dao.impl.ICategoryDAO;
import com.blueblood.dao.impl.IProductDAO;
import com.blueblood.model.Category;
import com.blueblood.model.Product;
import com.blueblood.service.ProductService;
import com.blueblood.service.impl.ICategoryService;
import com.blueblood.service.impl.IProductService;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller

@RequestMapping(value = "product")
public class ProductController implements IProductController {

    @Autowired
    IProductService productService;
    @Autowired
    IProductDAO productDAO;
    @Autowired
    ICategoryDAO categoryDAO;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    ProductService pService;
    @Autowired
    ServletContext servletContext;



//    Method for Image Upload. This is a method without service layer
    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public ModelAndView store(HttpServletRequest request, @RequestParam("pPhoto") MultipartFile file) throws IOException {

        String pName = request.getParameter("pName");
        String pCode = request.getParameter("pCode");
        //Get Category by category id
        int cId = Integer.parseInt(request.getParameter("cId"));
        Category c = categoryDAO.getById(cId);

        String pDesc = request.getParameter("pDesc");
        Double pPrice = Double.parseDouble(request.getParameter("pPrice"));
        int discount = Integer.parseInt(request.getParameter("discount"));

        Product p = new Product();
        p.setpName(pName);
        p.setpCode(pCode);
        p.setcId(c.getcId());
        p.setcName(c.getcName());
        p.setpDesc(pDesc);
        p.setpPrice(pPrice);
        p.setDiscount(discount);
        //This is for getting file name with extension
        String pPhoto = file.getOriginalFilename();
        //This is for saving file name in database with extension
        saveFile(file, pPhoto, "/resources/product/img");
        p.setpPhoto(pPhoto);
        Product t = productDAO.save(p);
        //}
        return new ModelAndView("redirect:/product/create");

    }

    private void saveFile(MultipartFile file, String fileName, String path) throws IOException {
        System.out.println("Start");
        byte[] bytes = file.getBytes();
        String filePath = servletContext.getRealPath(path);
        File directory = new File(filePath);
        File cFile = new File(
                //This is the location of your project file to save photo in your local pc
                "E:\\GitRepository\\Spring\\project\\new\\blueblood\\src\\main\\webapp\\resources\\product\\img"
                + File.separator + fileName);

        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(cFile));
        stream.write(bytes);
        stream.close();
        System.out.println(cFile);
    }

    @Override
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Category> catList = categoryService.getAll();
        map.put("catList", catList);
        return new ModelAndView("product/create", "map", map);
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Product t = productService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("/product/products", "map", map);

    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product c = productService.getById(id);
        c.setpId(id);
        return new ModelAndView("product/update", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Product c = productService.update(request);
        return new ModelAndView("product/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        Product c = productService.delete(id);
        return new ModelAndView("redirect:/product/view");
    }

    //To View
    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Product> pList = productService.getAll();
        map.put("pList", pList);
        return new ModelAndView("product/view", "map", map);
    }

    //To show product in Cart
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ModelAndView category() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Product> pList = productService.getAll();
        map.put("pList", pList);
        return new ModelAndView("home/category", "map", map);
    }

   //To return update page
   @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("product/update");
    }

    //Getting product to purchase
    @RequestMapping(value = "/purchase/{pId}", method = RequestMethod.GET)
    public ModelAndView purchase(ModelMap map, @PathVariable("pId") int pId) {
        Product product = productService.getById(pId);
       map.addAttribute("product", product);
        return new ModelAndView("purchase/create", "product", product);
    }
}
