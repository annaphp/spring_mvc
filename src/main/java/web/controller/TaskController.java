package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import core.model.Task;
import core.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	TaskService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listTasks(Model model){
		model.addAttribute("tasks", service.findAll());
		model.addAttribute("task",new Task());
		return "home";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveTask(Task task){
		service.save(task);
		return "redirect:/tasks/";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteTask(@PathVariable("id") Long id){
		service.deleteById(id);
		return "redirect:/tasks/";
	}
	
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String editTask(@PathVariable("id") Long id, Model model){
		model.addAttribute("task",service.findById(id));
		return "edit";
	}
	
}
