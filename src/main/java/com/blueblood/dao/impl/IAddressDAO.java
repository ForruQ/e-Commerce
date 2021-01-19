
package com.blueblood.dao.impl;

import com.blueblood.common.ICommonDAO;
import com.blueblood.model.Address;


public interface IAddressDAO extends ICommonDAO<Address>{
    public Address getByCid(int cid);
}
