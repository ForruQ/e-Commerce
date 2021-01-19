
package com.blueblood.service.impl;

import com.blueblood.common.ICommonService;
import com.blueblood.model.Orders;
import java.util.List;


public interface IOrdersService extends ICommonService<Orders>{
     public List<Orders> getByOrderNo(int orderNo);
}
