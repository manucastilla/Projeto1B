package mvc.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.model.User;
import mvc.model.UserDAO;

@Controller
public class ControllerLogin {
	@RequestMapping("/")
	public String entrar() {
		return "PaginaInicial";
	}
	
	
	@RequestMapping("fazLogin")
	public String fazLogin(User user, HttpSession session) throws SQLException {
		
		if (session == null) {
			return "redirec: /";}
		if (new UserDAO().verificationL(user)) {
			session.setAttribute("user", new UserDAO().getLogado(user));
			return "Menu";
		}
		else {
		return "XLogin";}

}
	// NAO CONSIGO FAZE LOGIN
	// cadastro deu errado
//	@RequestMapping("fazSignUp")
//	public String fazSignUp(User user) {
//	
//	}

	
	@RequestMapping("logout")
	 public String logout(HttpSession session) {
	 session.invalidate();
	 return "redirect:/";}
	
	
}
