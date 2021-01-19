
package com.blueblood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "dash")
public class DashboardController {
    
    @RequestMapping(value = "/dash")
    public String dash(){
        return "dash/dash";
    }
}
