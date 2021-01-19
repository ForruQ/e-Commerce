
package com.blueblood.dao.impl;

import com.blueblood.common.ICommonDAO;
import com.blueblood.model.Stock;


public interface IStockDAO extends ICommonDAO<Stock>{
    public Stock getByProductCode(String pCode);
}
