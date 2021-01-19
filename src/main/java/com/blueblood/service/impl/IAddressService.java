/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blueblood.service.impl;

import com.blueblood.common.ICommonService;
import com.blueblood.model.Address;

/**
 *
 * @author FORRUQ
 */
public interface IAddressService extends ICommonService<Address>{
    public Address getByCid(int cid);
}
