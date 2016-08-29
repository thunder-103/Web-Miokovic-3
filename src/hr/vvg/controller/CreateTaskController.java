package hr.vvg.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import hr.vvg.entiteti.Project;
import hr.vvg.entiteti.Task;
import hr.vvg.entiteti.TaskServiceMock;
import hr.vvg.entiteti.User;

@ManagedBean 
@RequestScoped
public class CreateTaskController {
	
	private List<User> userList;
	private List<Project> projectList;
	private List<Integer> estimatedTimeList;
	private User user;
	private Project project;
	private String taskDescription;
	private Integer estimatedTime;
	
	@PostConstruct
	private void init() {
		
		userList = TaskServiceMock.getUserList();
		projectList = TaskServiceMock.getProjectList();
		estimatedTimeList = TaskServiceMock.getEstimatedTimeList();
		
	}
	
	public String saveTask() {
		
		Task task = new Task(user, project, taskDescription, estimatedTime);
		
		TaskServiceMock.saveTask(task);
		
		return "/jsf/taskList.xhtml";
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public List<Integer> getEstimatedTimeList() {
		return estimatedTimeList;
	}

	public void setEstimatedTimeList(List<Integer> estimatedTimeList) {
		this.estimatedTimeList = estimatedTimeList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Integer getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(Integer estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	
	

}
