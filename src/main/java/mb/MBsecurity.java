package mb;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import util.message;

@ManagedBean(name = "mbSec")
@SessionScoped
public class MBsecurity {
	private static Map<String,Object> countries;
	private String userNmae;
	private String password;
	private boolean login;
	private String lang = "en";
	private Locale locale=Locale.ENGLISH;
	private String dir = "ltr";
 
	static {
		countries=new LinkedHashMap<String, Object>();
		countries.put("English" ,Locale.ENGLISH);
		countries.put("عربي" ,new Locale("ar"));
	}
	
	public String checkuser() {
		if (userNmae.equalsIgnoreCase("upskilling") && password.equals("upskilling@2022")) {
			login = true;
			return "/Home.xhtml";
		} else {
			login = false;
			message.addMessage("ERROR", "    ", "plase check your username or password ");
			return null;
		}

	}

	public String logout() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/Home.xhtml?faces-redirect=true";
	}
	
	public void localeChanged(ValueChangeEvent e) {
		lang = e.getNewValue().toString();
		for (Map.Entry<String, Object> entry : countries.entrySet()) {
			if (entry.getValue().toString().equals(lang)) {
				locale = lang.equals("en") ? Locale.ENGLISH : new Locale(lang);
				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
				dir = lang.equals("ar") ? "rtl" : "ltr";
			}
		}
	}
	
	public String getUserNmae() {
		return userNmae;
	}
	public void setUserNmae(String userNmae) {
		this.userNmae = userNmae;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public Map<String, Object> getCountries() {
		return countries;
	}

}
