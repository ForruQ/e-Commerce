
package com.blueblood.service;



import com.blueblood.dao.impl.ICountryDAO;
import com.blueblood.model.Country;
import com.blueblood.service.impl.ICountryService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "countryService")
public class CountryService implements ICountryService{
    
    @Autowired
    ICountryDAO countryDAO;

    @Override
    public Country save(HttpServletRequest request) {
      Map<String, String[]> map = request.getParameterMap();
        Country t = new Country();
         t.setName(map.get("name")[0]);
         return countryDAO.save(t);    
    }

    @Override
    public Country update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Country t = new Country();
        t.setId(Integer.parseInt(map.get("id")[0]));
         t.setName(map.get("name")[0]);
         return countryDAO.update(t); }

    @Override
    public Country delete(int id) {
       return countryDAO.delete(id);
    }

    @Override
    public List<Country> getAll() {
        return countryDAO.getAll();
       }

    @Override
    public Country getById(int id) {
     return countryDAO.getById(id);   
    }

   
}
