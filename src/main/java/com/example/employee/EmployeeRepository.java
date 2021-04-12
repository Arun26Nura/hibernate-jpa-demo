package com.example.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    EntityManager entity;

    public void saveEmployee(Employee employee){
        entity.persist(employee);
    }

    public List<Employee> getAllEmployees(){
        return entity.createQuery("SELECT e FROM Employee e",Employee.class).getResultList();
    }

}
