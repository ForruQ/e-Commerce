
package com.blueblood.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "bank")
@Table(name = "bank")
public class Bank {
    
    @Id
    private int bId;
    private String bName;
    private String bBranch;
    private String bAccountName;
    private String bAccountNumber;

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbBranch() {
        return bBranch;
    }

    public void setbBranch(String bBranch) {
        this.bBranch = bBranch;
    }

    public String getbAccountName() {
        return bAccountName;
    }

    public void setbAccountName(String bAccountName) {
        this.bAccountName = bAccountName;
    }

    public String getbAccountNumber() {
        return bAccountNumber;
    }

    public void setbAccountNumber(String bAccountNumber) {
        this.bAccountNumber = bAccountNumber;
    }

    
  
}
