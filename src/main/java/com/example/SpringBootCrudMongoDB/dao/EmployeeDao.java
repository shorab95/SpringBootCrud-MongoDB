package com.example.SpringBootCrudMongoDB.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootCrudMongoDB.model.Employee;

@Repository
public interface EmployeeDao extends MongoRepository<Employee,Integer> {

}
