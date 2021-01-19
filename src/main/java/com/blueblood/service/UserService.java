
package com.blueblood.service;



import com.blueblood.dao.impl.IUserDAO;
import com.blueblood.model.User;
import com.blueblood.service.impl.IUserService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserService implements IUserService{
    
    @Autowired
    IUserDAO userDAO;

    @Override
    public User save(HttpServletRequest request) {
      Map<String, String[]> map = request.getParameterMap();
        User t = new User();
         t.setuName(map.get("uName")[0]);
         t.setuEmail(map.get("uEmail")[0]);
         t.setuPassword(map.get("uPassword")[0]);
         t.setuPhone(map.get("uPhone")[0]);
         t.setuAddress(map.get("uAddress")[0]);
         return userDAO.save(t);    
    }

    @Override
    public User update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        User t = new User();
        t.setuId(Integer.parseInt(map.get("uId")[0]));
        t.setuName(map.get("uName")[0]);
         t.setuEmail(map.get("uEmail")[0]);
         t.setuPassword(map.get("uPassword")[0]);
         t.setuPhone(map.get("uPhone")[0]);
         t.setuAddress(map.get("uAddress")[0]);
         return userDAO.update(t); }

    @Override
    public User delete(int id) {
       return userDAO.delete(id);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
       }

    @Override
    public User getById(int id) {
     return userDAO.getById(id);   
    }

   
}
