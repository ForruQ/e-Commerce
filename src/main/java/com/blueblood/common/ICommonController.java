
package com.blueblood.common;


import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


public interface ICommonController {
    public ModelAndView create();
    public ModelAndView save(HttpServletRequest request);
    public ModelAndView edit(HttpServletRequest request);
    public ModelAndView update(HttpServletRequest request);
    public ModelAndView delete(int id);
    public ModelAndView getAll();
}
