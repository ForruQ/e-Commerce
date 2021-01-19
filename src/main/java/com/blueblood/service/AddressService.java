
package com.blueblood.service;



import com.blueblood.dao.impl.IAddressDAO;
import com.blueblood.model.Address;
import com.blueblood.service.impl.IAddressService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "addressService")
public class AddressService implements IAddressService{
    
    @Autowired
    IAddressDAO addressDAO;

    @Override
    public Address save(HttpServletRequest request) {
      Map<String, String[]> map = request.getParameterMap();
//      int cId = Integer.parseInt(request.getParameter("cId"));
      String fname = request.getParameter("fName");
      String lName = request.getParameter("lName");
      String street = request.getParameter("street");
      String zip = request.getParameter("zip");
      String city = request.getParameter("city");
      String country = request.getParameter("country");
      String phone = request.getParameter("phone");
      String email = request.getParameter("email");
      
        Address t = new Address();
        int cid = 1;
        t.setcId(cid);
        t.setfName(fname);
        t.setlName(lName);
        t.setStreet(street);
        t.setZip(zip);
        t.setCity(city);
        t.setCountry(country);
        t.setPhone(phone);
        t.setEmail(email);
       
         return addressDAO.save(t);    
    }

    @Override
    public Address update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Address t = new Address();
      
         return addressDAO.update(t); }

    @Override
    public Address delete(int id) {
       return addressDAO.delete(id);
    }

    @Override
    public List<Address> getAll() {
        return addressDAO.getAll();
       }

    @Override
    public Address getById(int id) {
     return addressDAO.getById(id);   
    }

    @Override
    public Address getByCid(int cid) {
        return addressDAO.getByCid(cid);
    }

   
}
