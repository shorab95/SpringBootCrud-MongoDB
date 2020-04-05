package com.example.SpringBootCrudMongoDB.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.SpringBootCrudMongoDB.dao.TopicDao;
import com.example.SpringBootCrudMongoDB.model.Topic;
import com.example.SpringBootCrudMongoDB.service.TopicService;

@RunWith(SpringRunner.class)
public class TopicApiTest {
	@InjectMocks
	private TopicController topicController;

	private MockMvc mockMvc;
	@Mock
	private TopicService topicService;

	@Mock
	private TopicDao topicDao;

	ArrayList<Topic> al = new ArrayList<Topic>();

	Topic t1;
	Topic t2;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(topicController).build();

		Topic t1 = new Topic("Spring", "SpringBoot", "SpringBoot Description");
		Topic t2 = new Topic("Spring2", "SpringBoot1", "SpringBoot Description");
		al.add(t1);
		al.add(t2);
	}

	@Test
	public void testgetTopic() throws Exception {

		when(topicDao.findAll()).thenReturn(al);
		mockMvc.perform(MockMvcRequestBuilders.get("/gettopics").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
		assertEquals(al, topicDao.findAll());

	}

	@Test
	public void testcreateTopic() throws Exception {
		when(topicDao.save(t1)).thenReturn(t1);
		assertEquals(t1, topicDao.save(t1));
	}

	@Test
	public void testDeleteTopicById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/deleteTopic/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

}
