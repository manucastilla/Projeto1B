package mvc.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.model.Notes;
import mvc.model.NotesDAO;

@Controller
public class ControllerNotes {

	@RequestMapping("postar")
	 public String postar(Notes note) throws SQLException {
		NotesDAO dao = new NotesDAO();
		dao.postNotas(note);
	 return "Menu";}
	
	@RequestMapping("delete")
	 public String delete(Notes note) throws SQLException {
		NotesDAO dao = new NotesDAO();
		dao.deletarNotas(note.getId());
	 return "Menu";}
	
	@RequestMapping("editaGet")
	public String editaPost(Notes note, HttpSession session) {		
		session.setAttribute("nota", note.getNota());
		session.setAttribute("titulo", note.getTitulo());
		session.setAttribute("id", note.getId());
		return "Editar";}
	
	@RequestMapping("editaPost")
	public String editaPost(Notes note) throws SQLException {		
		NotesDAO dao = new NotesDAO();
		dao.editarNotas(note);
		return "Menu";}
	
}
