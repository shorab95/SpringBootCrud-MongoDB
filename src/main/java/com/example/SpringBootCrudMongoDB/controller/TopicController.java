package com.example.SpringBootCrudMongoDB.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootCrudMongoDB.model.Topic;
import com.example.SpringBootCrudMongoDB.service.TopicService;

@RestController
public class TopicController {

	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/hello")
	public String getHello()
	{
		return "HelloWorld";
	}
	
	@GetMapping("/gettopics")
    public List<Topic> getTopics()
    {
		return topicService.findAll();
    }
	@GetMapping("/getTopic/{id}")
	public Optional<Topic> getTopicById(@PathVariable String id)
	{
		return topicService.getTopicById(id);
	}
	
	@PostMapping("/createTopic")
	public Topic createTopic(@RequestBody Topic topic)
	{
		return topicService.createTopic(topic);
	}
	@DeleteMapping("/deleteTopic/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		topicService.deleteById(id);
	}
//	@PutMapping("/topic/{id}")
//	public void updateTopic(@RequestBody Topic topic,@PathVariable String id )
//	{
//		topicService.updateById(topic,id);
//	}
}
