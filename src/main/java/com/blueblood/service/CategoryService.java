
package com.blueblood.service;



import com.blueblood.dao.impl.ICategoryDAO;
import com.blueblood.model.Category;
import com.blueblood.service.impl.ICategoryService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "categoryService")
public class CategoryService implements ICategoryService{
    
    @Autowired
    ICategoryDAO categoryDAO;

    @Override
    public Category save(HttpServletRequest request) {
      Map<String, String[]> map = request.getParameterMap();
        Category t = new Category();
         t.setcName(map.get("cName")[0]);
         t.setcDescription(map.get("cDescription")[0]);
         return categoryDAO.save(t);    
    }

    @Override
    public Category update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Category t = new Category();
        t.setcId(Integer.parseInt(map.get("cId")[0]));
        t.setcName(map.get("cName")[0]);
         t.setcDescription(map.get("cDescription")[0]);
         return categoryDAO.update(t); }

    @Override
    public Category delete(int id) {
       return categoryDAO.delete(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryDAO.getAll();
       }

    @Override
    public Category getById(int id) {
     return categoryDAO.getById(id);   
    }

   
}
