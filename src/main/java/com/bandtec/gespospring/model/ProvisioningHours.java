package com.bandtec.gespospring.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ProvisioningHours extends AbstractModel {

    private Integer amountHours;

    public ProvisioningHours() {}

    public ProvisioningHours(Integer amountHours) {
        this.amountHours = amountHours;
    }

    public Integer getAmountHours() {
        return amountHours;
    }

    public void setAmountHours(Integer amountHours) {
        this.amountHours = amountHours;
    }
}
