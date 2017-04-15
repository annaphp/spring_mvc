package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import core.model.Task;
import core.service.TaskService;

@Controller
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
		return "redirect:/";
	}

}
