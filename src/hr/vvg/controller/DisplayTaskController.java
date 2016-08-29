package hr.vvg.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import hr.vvg.entiteti.Task;
import hr.vvg.entiteti.TaskServiceMock;

@ManagedBean 
@RequestScoped
public class DisplayTaskController {
	
	private List<Task> taskList;
	
	@PostConstruct
	private void init() {
		
		taskList = TaskServiceMock.getTaskList();
	}
	
	public String backButton() {
		
		return "/jsf/createTask.xhtml";
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	
	

}
