package com.example.SpringBootCrudMongoDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringBootCrudMongoDB.dao.EmployeeDao;
import com.example.SpringBootCrudMongoDB.model.Employee;
import com.example.SpringBootCrudMongoDB.exception.EmployeeNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeDao empDao;

	@GetMapping(value = "/getAllEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployee() {

		List<Employee> emp = empDao.findAll();
		return emp;

	}

	@GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public String helloResource() {
		return "helloWorld";
	}
	@GetMapping("/helloWorld")
	public String getHello()
	{
		return "Hello Wolrld";
	}

	@GetMapping("/json")
	public Employee json() {
		return new Employee("Shorab", 4, "DBD");
	}

	private void printEmp(List<Employee> emp) {
		emp.forEach(n -> System.out.println(n + ","));
	}

	@DeleteMapping("/deleteEmployee/{empid}")
	public void deleteEmployee(@PathVariable("empid") Integer empid) {
		empDao.deleteById(empid);
	}

	@PostMapping("/createEmployee")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return empDao.save(emp);
	}
	

}

//// Get a new connection to the db assuming that it is running
//MongoClient mongoClient = new MongoClient();
//
//// use test as a datbase,use your database here
//DB db = mongoClient.getDB("admin");
//
//// //fetch the collection object ,car is used here,use your own
//DBCollection collection = db.getCollection("employee");
//
//// //invoking find() method and storing the result in carCursor
//for (DBObject cur : collection.find())
//{
//	if(!cur.equals(emp))
//	{
//		 return empDao.save(emp);
//	}
//}
//	@GetMapping("/getEmployee/{empId}")
//    public Employee getEmpById(@PathVariable ("empId") Integer empId)
//    {
//        Optional<Employee> e=empDao.findById(empId);
//        returm e;
//    }