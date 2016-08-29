package hr.vvg.servleti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import hr.vvg.entiteti.Project;
import hr.vvg.entiteti.Task;
import hr.vvg.entiteti.User;

/**
 * Servlet implementation class ShowTaskServlet
 */
@WebServlet("/showTask")
public class ShowTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTaskServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//kreiranje liste korisnika
		List<User> userList = new ArrayList<>();
		
		userList = createUserList(userList);
		
		request.setAttribute("userList", userList);
		
		//kreiranje liste projekata
		List<Project> projectList = new ArrayList<>();

		projectList = createProjectList(projectList);
		
		request.setAttribute("projectList", projectList);
		
		ServletContext sc = getServletContext();
		
	    RequestDispatcher rd = sc.getRequestDispatcher("/createTask.jsp");

	    rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//kreiranje liste korisnika
		List<User> userList = new ArrayList<>();
		
		userList = createUserList(userList);
		
		//dohvaæanje objekta odabranog korisnika
		String selectedUser = request.getParameter("selectedUser");
		
		Integer idUser = Integer.parseInt(selectedUser);
		
		User selectedObjectUser = null;
		
		for(User user: userList) {
			
			if(user.getUserId().equals(idUser)){
				
				selectedObjectUser = user;
				
			}
			
		}
		
		//kreiranje liste projekata
		List<Project> projectList = new ArrayList<>();

		projectList = createProjectList(projectList);
		
		//dohvaæanje objekta odabranog projekta
		String selectedProject = request.getParameter("selectedProject");
		
		Integer idProject = Integer.parseInt(selectedProject);
		
		Project selectedObjectProject = null;
		
		for(Project project: projectList) {
			
			if(project.getProjectId().equals(idProject)){
				
				selectedObjectProject = project;
				
			}
			
		}
		
		String taskDescription = request.getParameter("taskDescription");
		
		Integer selectedTime = Integer.parseInt(request.getParameter("selectedTime"));
		
		//kreiranje zadatka
		Task task = new Task(selectedObjectUser, selectedObjectProject, taskDescription, selectedTime);
		
		//request.setAttribute("task", task);
		
		List<Task> taskList = new ArrayList<>();
		
		taskList.add(task);
		
		ServletContext sc = getServletContext();
			
		RequestDispatcher rd = sc.getRequestDispatcher("/displayTask.jsp");
		
		 
	    //kreiranje sessiona
	    HttpSession session = request.getSession(false);
	    
	    if(session == null) {
	    	
	    	session = request.getSession();
	    	
	    }
	    
	    if(session.getAttribute("taskList") == null) {
	    	
	    	session.setAttribute("taskList", taskList);
	    	
	    } else {
	    
	    @SuppressWarnings("unchecked")
		List<Task> oldTaskList = (List<Task>) session.getAttribute("taskList");
	    
	    oldTaskList.add(task);
	    
	    session.setAttribute("oldTaskList", oldTaskList);
	    
	    }

		rd.forward(request, response);
		
			
}


		
	
	//metoda za kreiranje liste korisnika
	private List<User> createUserList(List<User> userList) {
		
		userList.add(new User(1, "jstar", "Jasmin", "Stavros" ));
		
		userList.add(new User(2, "mhrni", "Milo", "Hrniæ" ));
		
		userList.add(new User(3, "mkova", "Mišo", "Kovaè" ));
		
		return userList;
		
	}
	//metoda za kreiranje liste projekata
	private List<Project> createProjectList(List<Project> projectList) {
		
		projectList.add(new Project(1, "Umoran", "Croatia Records"));
		
		projectList.add(new Project(2, "Konji bijeli", "Menart"));
		
		projectList.add(new Project(3, "Uvijek ista", "Jugoton"));
		
		return projectList;
		
	}

}
