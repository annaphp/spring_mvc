package core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.model.Task;
import core.model.TaskRepo;
@Service
public class TaskService {
   
	private TaskRepo repo;
	
	@Autowired
	public TaskService(TaskRepo repo){
		this.repo = repo;
	}
	
	public Task save(Task task){
		return repo.saveAndFlush(task);
	}
	
	public List<Task> findAll(){
		return repo.findAll();
	}

	public void deleteById(Long id) {
		repo.delete(id);
	}
	
	public Task findById(Long id){
		return repo.findOne(id);
	}
}
