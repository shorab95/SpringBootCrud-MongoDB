package com.example.SpringBootCrudMongoDB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.SpringBootCrudMongoDB.dao.TopicDao;
import com.example.SpringBootCrudMongoDB.model.Topic;

@Service
public class TopicService {
	
	@Autowired
	private TopicDao topicDao;

	public List<Topic> findAll() {
		return topicDao.findAll();
	}

	public Optional<Topic> getTopicById(String id) {
		return topicDao.findById(id);
	}

	public Topic createTopic(Topic topic) {
		return topicDao.save(topic);
	}

	public void deleteById(String id) {
      topicDao.deleteById(id);		
	}

//	public void updateById(Topic topic, String id) {
//     topicDao.save(topic);		
//	}
	
    
}
