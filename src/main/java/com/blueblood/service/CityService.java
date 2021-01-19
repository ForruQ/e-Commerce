package com.blueblood.service;

import com.blueblood.dao.impl.ICityDAO;
import com.blueblood.dao.impl.ICountryDAO;
import com.blueblood.model.City;
import com.blueblood.model.Country;
import com.blueblood.service.impl.ICityService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "cityService")
public class CityService implements ICityService {

    @Autowired
    ICityDAO cityDAO;

    @Autowired
    ICountryDAO countryDAO;

    @Override
    public City save(HttpServletRequest request) {
        String name = request.getParameter("name");
        City t = new City();
        t.setName(name);
        return cityDAO.save(t);
    }

    @Override
    public City update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        City t = new City();
        t.setId(Integer.parseInt(map.get("id")[0]));
        t.setName(map.get("name")[0]);
        return cityDAO.update(t);
    }

    @Override
    public City delete(int id) {
        return cityDAO.delete(id);
    }

    @Override
    public List<City> getAll() {
        return cityDAO.getAll();
    }

    @Override
    public City getById(int id) {
        return cityDAO.getById(id);
    }

}
