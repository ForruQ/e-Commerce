package com.blueblood.service;

import com.blueblood.dao.impl.ITemporaryTableDAO;
import com.blueblood.model.TemporaryTable;
import com.blueblood.service.impl.ITemporaryTableService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "temporaryTableService")
public class TemporaryTableService implements ITemporaryTableService {

    @Autowired
    ITemporaryTableDAO temporaryTableDAO;

    @Override
    public TemporaryTable save(HttpServletRequest request) {

        Map<String, String[]> map = request.getParameterMap();
        String[] ids = map.get("ids[]");
        String[] pId = (String[]) map.get("pId[]");
        String[] pName = (String[]) map.get("pName[]");
        String[] pCode = (String[]) map.get("pCode[]");
        String[] pPhoto = (String[]) map.get("pPhoto[]");
        String[] pPrice = (String[]) map.get("pPrice[]");
        String[] discount = (String[]) map.get("discount[]");
        String[] qty = (String[]) map.get("qty[]");
        String[] total = (String[]) map.get("total[]");
        String[] cId = (String[]) map.get("cId[]");

        TemporaryTable t = new TemporaryTable();

        for (int i = 0; i < ids.length; i++) {
            t.setpId(Integer.parseInt(pId[i]));
            t.setpName(pName[i]);
            t.setpCode(pCode[i]);
            t.setpPhoto(pPhoto[i]);
            t.setpPrice(Double.parseDouble(pPrice[i]));
            t.setDiscount(Integer.parseInt(discount[i]));
            t.setQty(Integer.parseInt(qty[i]));
            t.setTotal(Double.parseDouble(total[i]));
            t.setcId(Integer.parseInt(cId[i]));

            temporaryTableDAO.save(t);
        }
        return t;

    }

    @Override
    public TemporaryTable update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        TemporaryTable t = new TemporaryTable();

        return temporaryTableDAO.update(t);
    }

    @Override
    public TemporaryTable delete(int id) {
        return temporaryTableDAO.delete(id);
    }

    @Override
    public List<TemporaryTable> getAll() {
        return temporaryTableDAO.getAll();
    }

    @Override
    public TemporaryTable getById(int id) {
        return temporaryTableDAO.getById(id);
    }

}
