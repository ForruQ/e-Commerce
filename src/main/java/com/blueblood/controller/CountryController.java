
package com.blueblood.controller;




import com.blueblood.controller.impl.ICountryController;
import com.blueblood.model.Country;
import com.blueblood.service.impl.ICountryService;
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


@RequestMapping(value = "country")
public class CountryController implements ICountryController{
    @Autowired
    ICountryService countryService;
    
    

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("country/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        return new ModelAndView("country/create");
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
      Country t = countryService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("/country/create", "map", map);
       
    }

    @Override
        @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Country c = countryService.getById(id);
        c.setId(id);
       return new ModelAndView("country/update", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Country c =  countryService.update(request);
        return new ModelAndView("country/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
    Country c = countryService.delete(id);
       return new ModelAndView("redirect:/country/view");    
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
    Map<String, Object> map = new HashMap<String, Object>();
    List<Country> cList = countryService.getAll();
    map.put("cList", cList);
    return new ModelAndView("country/view", "map", map);
    }

 
    
}
