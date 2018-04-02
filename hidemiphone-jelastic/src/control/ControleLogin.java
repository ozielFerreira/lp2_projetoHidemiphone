package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidade.Adm;
import service.ServiceAdm;

/**
 * Servlet implementation class ControleLogin
 */
@WebServlet({"/login", "/admin/Logout"})
public class ControleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleLogin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath();
		if(url.equals("/admin/Logout")) {
			logout(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath();
		if(url.equals("/login")) {
			login(request, response);
			
		} 
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServiceAdm ad = new ServiceAdm();
		HttpSession sessao = request.getSession();
		String email = request.getParameter("ademail");
		String senha = request.getParameter("adsenha");
		try {
			Adm admin = ad.buscarLogin(email, senha);
			if (admin != null) {
				sessao.setAttribute("admin", admin);
				if((Boolean)sessao.getAttribute("trocaSenha") != null) {
					response.sendRedirect("admin/perfil.jsp#trocaSenha");
					sessao.removeAttribute("trocaSenha");
				} else {
					response.sendRedirect("admin/index.jsp");
				}
			}else {
				request.setAttribute("msg", "<div class='alert alert-info'>Usuario ou senha invalidos, tente novamente</div>");
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession sessao = request.getSession();
		sessao.removeAttribute("admin");
		
	
		response.sendRedirect("../admin");
	}

}
