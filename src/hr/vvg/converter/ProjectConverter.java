package hr.vvg.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import hr.vvg.entiteti.Project;
import hr.vvg.entiteti.TaskServiceMock;


@ManagedBean(name = "projectConverterBean")
@FacesConverter(value = "projectConverter")
public class ProjectConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
	String value) {
		if(value instanceof String && "".equals(value)) {
			
			return "";
			
		}
		return findProjectById(Integer.parseInt(value));
		
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component,
	Object value) {
		if(value instanceof String && "".equals(value)) {
			
			return "";
			
		}
		Project project = (Project) value;
		return String.valueOf(project.getProjectId());
	}
	
	private Project findProjectById(Integer id) {
		
		Project project = null;
		
		for(Project temp : TaskServiceMock.getProjectList()) {
			if(temp.getProjectId() == id) {
				
				project = temp;
				break;
			}
			
		}
		return project;
	}

}
