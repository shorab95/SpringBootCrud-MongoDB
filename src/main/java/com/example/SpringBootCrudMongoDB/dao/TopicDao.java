package com.example.SpringBootCrudMongoDB.dao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootCrudMongoDB.model.Topic;

@Repository
public interface TopicDao extends MongoRepository<Topic,String>{

}
