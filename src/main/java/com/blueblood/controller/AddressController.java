
package com.blueblood.controller;




import com.blueblood.controller.impl.IAddressController;
import com.blueblood.model.Address;
import com.blueblood.service.impl.IAddressService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller


@RequestMapping(value = "address")
public class AddressController implements IAddressController{
    @Autowired
    IAddressService addressService;
    
    

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("address/update");
    }
     @RequestMapping(value = "/register")
    public ModelAndView register() {
        return new ModelAndView("address/register");
    }
     @RequestMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("address/login");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        return new ModelAndView("address/create");
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
      Address t = addressService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("home/checkout1", "map", map);
       
    }

    @Override
        @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Address c = addressService.getById(id);
        c.setId(id);
       return new ModelAndView("address/update", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Address c =  addressService.update(request);
        return new ModelAndView("address/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
    Address c = addressService.delete(id);
       return new ModelAndView("redirect:/address/view");    
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
    Map<String, Object> map = new HashMap<String, Object>();
    List<Address> cList = addressService.getAll();
    map.put("cList", cList);
    return new ModelAndView("address/view", "map", map);
    }

     @RequestMapping(value = "/address/{cId}", method = RequestMethod.GET)
    public ModelAndView getByOrderNo(ModelMap map, @PathVariable("cId") int cId){
        Address address = addressService.getByCid(cId) ;
       map.addAttribute("address", address);
       return new ModelAndView("orders/address");  
    }
 
    
}
