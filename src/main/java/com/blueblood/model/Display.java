
package com.blueblood.model;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Display {
    
    @Id
    private int id;
    private int pId;
    private String name;
    private String code;
    private int cId;
    private String cName;
    private String desc;
    private String photo;
    private double price;
    private int discount;
    private double dPrice;
}
