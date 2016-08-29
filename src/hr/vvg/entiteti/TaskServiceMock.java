package hr.vvg.entiteti;

import java.util.ArrayList;
import java.util.List;

public class TaskServiceMock {
	
	private static List<User> userList;
	private static List<Project> projectList;
	private static List<Integer> estimatedTimeList;
	private static List<Task> taskList;
	
	static {
		
		userList = new ArrayList<User>();
		
		userList.add(new User(1, "jstar", "Jasmin", "Stavros" ));
		
		userList.add(new User(2, "mhrni", "Milo", "Hrniæ" ));
		
		userList.add(new User(3, "mkova", "Mišo", "Kovaè" ));
		
		projectList = new ArrayList<Project>();
		
		projectList.add(new Project(1, "Umoran", "Croatia Records"));
		
		projectList.add(new Project(2, "Konji bijeli", "Menart"));
		
		projectList.add(new Project(3, "Uvijek ista", "Jugoton"));
		
		estimatedTimeList = new ArrayList<Integer>();
		
		for(int i=1; i<9; i++){
		
			estimatedTimeList.add(i);
		
		}
		
	}
	
	public static List<Task> saveTask (Task task) {
		
		if(taskList == null){
		
			taskList = new ArrayList<Task>();
		
		}
		
		taskList.add(task);
		
		return taskList;
		
	}

	public static List<User> getUserList() {
		return userList;
	}

	public static List<Project> getProjectList() {
		return projectList;
	}

	public static List<Integer> getEstimatedTimeList() {
		return estimatedTimeList;
	}

	public static List<Task> getTaskList() {
		return taskList;
	}

	
}
