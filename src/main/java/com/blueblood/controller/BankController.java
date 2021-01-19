
package com.blueblood.controller;




import com.blueblood.controller.impl.IBankController;
import com.blueblood.model.Bank;
import com.blueblood.service.impl.IBankService;
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


@RequestMapping(value = "bank")
public class BankController implements IBankController{
    @Autowired
    IBankService bankService;
    
    

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("bank/update");
    }
     @RequestMapping(value = "/register")
    public ModelAndView register() {
        return new ModelAndView("bank/register");
    }
     @RequestMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("bank/login");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        return new ModelAndView("bank/create");
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
      Bank t = bankService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("/bank/register", "map", map);
       
    }

    @Override
        @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Bank c = bankService.getById(id);
        c.setbId(id);
       return new ModelAndView("bank/update", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Bank c =  bankService.update(request);
        return new ModelAndView("bank/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
    Bank c = bankService.delete(id);
       return new ModelAndView("redirect:/bank/view");    
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
    Map<String, Object> map = new HashMap<String, Object>();
    List<Bank> cList = bankService.getAll();
    map.put("cList", cList);
    return new ModelAndView("bank/view", "map", map);
    }

 
    
}
