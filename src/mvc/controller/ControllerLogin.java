package mvc.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mvc.model.User;
import mvc.model.UserDAO;

@Controller
public class ControllerLogin {
	@RequestMapping("entrar")
	public String entrar() {
		return "PaginaInicial";
	}
	
	
	@RequestMapping("fazLogin")
	public String fazLogin(User user, HttpSession session) throws SQLException {
		
		if (session == null) {
			return "redirect: entrar";}
		if (new UserDAO().verificationL(user)) {
			session.setAttribute("user", new UserDAO().getLogado(user));
			return "Menu";
		}
		else {
		return "XLogin";}

}
	
	@RequestMapping(value = "fazSignUp", method= RequestMethod.POST)
	public String fazSignUp(User user, 
			@ModelAttribute("password") String password, 
			@ModelAttribute("checkPassword") String checkPassword) throws SQLException {
		UserDAO dao = new UserDAO();
		if (dao.verificationC(user)) {
			return "CadastroFeito";}
		else {
			if(password.contentEquals(checkPassword)) {
				dao.postUser(user);
				return "PaginaInicial";
			} else {
				return "XSignUp";
			}
			
		}		
	}

	
	@RequestMapping("logout")
	 public String logout(HttpSession session) {
	 session.invalidate();
	 return "redirect:entrar";}
	
	
}
