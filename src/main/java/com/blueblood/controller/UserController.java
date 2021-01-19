
package com.blueblood.controller;




import com.blueblood.controller.impl.IUserController;
import com.blueblood.model.User;
import com.blueblood.service.impl.IUserService;
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


@RequestMapping(value = "user")
public class UserController implements IUserController{
    @Autowired
    IUserService userService;
    
    

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("user/update");
    }
     @RequestMapping(value = "/register")
    public ModelAndView register() {
        return new ModelAndView("user/register");
    }
     @RequestMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("user/login");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        return new ModelAndView("user/create");
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
      User t = userService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("/user/register", "map", map);
       
    }

    @Override
        @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        User c = userService.getById(id);
        c.setuId(id);
       return new ModelAndView("user/update", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        User c =  userService.update(request);
        return new ModelAndView("user/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
    User c = userService.delete(id);
       return new ModelAndView("redirect:/user/view");    
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
    Map<String, Object> map = new HashMap<String, Object>();
    List<User> cList = userService.getAll();
    map.put("cList", cList);
    return new ModelAndView("user/view", "map", map);
    }

 
    
}
