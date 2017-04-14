package model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import core.CoreConfiguration;
import core.model.Task;
import core.service.TaskService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CoreConfiguration.class)
public class TaskServiceTest {
	
	@Autowired
	TaskService service;
	
	@Test
	public void shouldSave(){
		Task task = new Task ("dishes", "do dishes well");
		service.save(task);
		assertTrue(service.findAll().contains(task));
	}
	

}
