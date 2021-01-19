
package com.blueblood.service;



import com.blueblood.dao.impl.IBankDAO;
import com.blueblood.model.Bank;
import com.blueblood.service.impl.IBankService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "bankService")
public class BankService implements IBankService{
    
    @Autowired
    IBankDAO bankDAO;

    @Override
    public Bank save(HttpServletRequest request) {
      Map<String, String[]> map = request.getParameterMap();
        Bank t = new Bank();
         t.setbName(map.get("uName")[0]);
         t.setbBranch(map.get("uEmail")[0]);
         t.setbAccountName(map.get("uPassword")[0]);
         t.setbAccountNumber(map.get("uPhone")[0]);
         return bankDAO.save(t);    
    }

    @Override
    public Bank update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Bank t = new Bank();
        t.setbId(Integer.parseInt(map.get("bId")[0]));
        t.setbName(map.get("bName")[0]);
         t.setbBranch(map.get("bBranch")[0]);
         t.setbAccountName(map.get("bAccountName")[0]);
         t.setbAccountNumber(map.get("bAccountNumber")[0]);
         return bankDAO.update(t); }

    @Override
    public Bank delete(int id) {
       return bankDAO.delete(id);
    }

    @Override
    public List<Bank> getAll() {
        return bankDAO.getAll();
       }

    @Override
    public Bank getById(int id) {
     return bankDAO.getById(id);   
    }

   
}
