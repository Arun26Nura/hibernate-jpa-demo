package com.example.employee;

import java.math.BigDecimal;

public class PermanentEmployee extends Employee{

    private BigDecimal salary;

    public PermanentEmployee(String name,BigDecimal salary) {
        super(name);
        this.salary=salary;
    }
}
