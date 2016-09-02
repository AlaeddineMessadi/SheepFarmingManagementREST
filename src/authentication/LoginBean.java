package authentication;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import persistance.Admin;
import persistance.User;


@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
	@EJB
	services.userServices.UserServicesLocal local;
	private String userType;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	private boolean logedIn;

	public boolean isLogedIn() {
		return logedIn;
	}

	public void setLogedIn(boolean logedIn) {
		this.logedIn = logedIn;
	}

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String doLogin() {
		user = local.authenticate(user.getLogin(), user.getPwd());
		if (user != null) {
			logedIn = true;
			if (user instanceof Admin) {
				userType = "Admin";
				return "/pages/admin/espaceAdmin?faces-redirect=true";
			} else {
				userType = "Employee";
				return "/pages/employee/espaceEmployee?faces-redirect=true";
			}
		}else
		{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erreur ","Erreur d'authentification");

			FacesContext.getCurrentInstance().addMessage(null, msg);
		return null;
		}
	}

	public String logOut() {
FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		return "/faces/welcome.xhtml?faces-redirect=true";
	}
}
