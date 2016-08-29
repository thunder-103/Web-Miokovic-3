package hr.vvg.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import hr.vvg.entiteti.TaskServiceMock;
import hr.vvg.entiteti.User;

@ManagedBean(name = "userConverterBean")
@FacesConverter(value = "userConverter")
public class UserConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
	String value) {
		if(value instanceof String && "".equals(value)) {
			
			return "";
			
		}
		return findUserById(Integer.parseInt(value));
		
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component,
	Object value) {
		if(value instanceof String && "".equals(value)) {
			
			return "";
			
		}
		User user = (User) value;
		return String.valueOf(user.getUserId());
	}
	
	private User findUserById(Integer id) {
		
		User user = null;
		
		for(User temp : TaskServiceMock.getUserList()) {
			if(temp.getUserId() == id) {
				
				user = temp;
				break;
			}
			
		}
		return user;
	}


}
