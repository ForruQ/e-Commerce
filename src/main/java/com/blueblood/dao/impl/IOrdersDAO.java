
package com.blueblood.dao.impl;

import com.blueblood.common.ICommonDAO;
import com.blueblood.model.Orders;
import java.util.List;




public interface IOrdersDAO extends ICommonDAO<Orders>{
    public List<Orders> getByOrderNo(int orderNo);
}
