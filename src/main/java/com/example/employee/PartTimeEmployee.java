package com.example.employee;

import java.math.BigDecimal;

public class PartTimeEmployee extends  Employee{

    private BigDecimal hourlyWage;

    public PartTimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }
}
