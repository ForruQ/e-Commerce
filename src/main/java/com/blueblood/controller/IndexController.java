
package com.blueblood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
  
    @RequestMapping(value = "")
    public String index(){
        return "home/index";
    }
    @RequestMapping(value = "/dash")
    public String dash(){
        return "common/dashboard";
    }
 
     
}
