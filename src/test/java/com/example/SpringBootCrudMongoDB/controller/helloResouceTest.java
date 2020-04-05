package com.example.SpringBootCrudMongoDB.controller;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.SpringBootCrudMongoDB.dao.EmployeeDao;
import com.example.SpringBootCrudMongoDB.model.Employee;
import com.example.SpringBootCrudMongoDB.service.TaxService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
public class helloResouceTest {
	
	@InjectMocks
	private EmployeeController empController;
	
	@MockBean
	private TaxService taxService;
	
	@Mock
	private EmployeeDao empDao;
	
	
	private MockMvc mockMvc;
	
	ObjectMapper m = new ObjectMapper();
	
	ArrayList<Employee> al = new ArrayList<Employee>();
	
	Employee emp1=null;
	
	Employee emp2=null;
	
	@Before
	public void setUp() throws Exception
	{ 
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(empController).build();
		Employee emp1=new Employee("Shorab",5,"DBD");
    	Employee emp2=new Employee("Moony",6,"KOL");
    	al.add(emp1);
    	al.add(emp2);
	}
	@Test
	public void testHelloResource() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/employees/hello"))
		.andExpect(MockMvcResultMatchers.status().isOk()).
		andExpect(MockMvcResultMatchers.content()
				.string("helloWorld"));
	}
    @Test
    public void testJson() throws Exception
    {
    	Employee emp1=new Employee("Shorab",4,"DBD");
    	MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/employees/json").accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    	String js=m.writeValueAsString(emp1);
    	assertEquals(js,mvcResult.getResponse().getContentAsString());
    	
    }
    @Test
    public void testgetEmployees() throws Exception
    {
    	
    	
    	when(empDao.findAll()).thenReturn(al);
    	MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/employees/getAllEmployee").accept(MediaType.APPLICATION_JSON))
    			.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    	assertEquals( m.writeValueAsString(al),mvcResult.getResponse().getContentAsString());
    	}
    
    @Test
    public void testAddEmployee() throws Exception
    {
    	
    	when(empDao.save(emp1)).thenReturn(emp1);
    	assertEquals(emp1,empDao.save(emp1));

     
    }
    @Test
    public void testdeleteEmployee() throws Exception
    {
    	mockMvc.perform(MockMvcRequestBuilders.delete("/employees/deleteEmployee/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
    	
    }
    @Test
    public void testIncome()
    {
    	int income=5000;
    	when(taxService.getBracket(income)).thenReturn("HIGH");
    	assertEquals("HIGH",taxService.getBracket(income));
    }
    
    @Test
    public void testWord()
    {
    	String s="Shorab";
    	when(taxService.countA(s)).thenReturn(1);
    	assertEquals(1,taxService.countA(s));
    }
	@Test
	public void testTwoString()
	{
		String s1="Sho";
		String s2="Sho";
		when(taxService.compareTwoString(s1, s2)).thenReturn(true);
		assertEquals(true,taxService.compareTwoString(s1, s2));
	}
	@Test
	public void testArray()
	{
		int[] arr=new int[] {2,3};
		when(taxService.addOneTOArr(arr)).thenReturn(new int[] {3,4});
		assertArrayEquals(new int[] {3,4},taxService.addOneTOArr(arr));
	}
	@Test(timeout=1000)
	public void testPerformance()
	{
		taxService.performance();
	}
}
