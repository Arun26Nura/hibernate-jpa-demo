package com.example.employee;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class PermanentEmployee extends Employee{

    private BigDecimal salary;

    public PermanentEmployee(String name,BigDecimal salary) {
        super(name);
        this.salary=salary;
    }

    public PermanentEmployee() {

    }
}
