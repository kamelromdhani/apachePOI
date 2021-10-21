package com.example.apachePOI;

import java.util.Objects;

public class PushMail {
    String customerName;
    String accountID;
    String CompiledEmail;
    String configurationName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PushMail)) return false;
        PushMail pushMail = (PushMail) o;
        return getAccountID().equals(pushMail.getAccountID()) && getConfigurationName().equals(pushMail.getConfigurationName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountID(), getConfigurationName());
    }

    @Override
    public String toString() {
        return "PushMail{" +
                "customerName='" + customerName + '\'' +
                ", accountID='" + accountID + '\'' +
                ", CompiledEmail='" + CompiledEmail + '\'' +
                ", configurationName='" + configurationName + '\'' +
                '}';
    }

    public PushMail(){}

    public PushMail(String customerName, String accountID, String compiledEmail, String configurationName) {
        this.customerName = customerName;
        this.accountID = accountID;
        CompiledEmail = compiledEmail;
        this.configurationName = configurationName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getCompiledEmail() {
        return CompiledEmail;
    }

    public void setCompiledEmail(String compiledEmail) {
        CompiledEmail = compiledEmail;
    }

    public String getConfigurationName() {
        return configurationName;
    }

    public void setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
    }
}
