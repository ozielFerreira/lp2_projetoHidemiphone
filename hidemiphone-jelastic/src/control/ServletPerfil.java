package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidade.Adm;
import service.ServiceAdm;

/**
 * Servlet implementation class ServletPerfil
 */
@WebServlet({"/ServletPerfil","/admin/editar_perfil"})
public class ServletPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletPerfil() {

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/admin/editar_perfil")) {
			editarSenha(request, response);
		}
	}
	protected void editarSenha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServiceAdm ad = new ServiceAdm();
			if (ad.verificaSenha(request.getParameter("senha") )== true) {
				Long id = Long.parseLong(request.getParameter("id"));
				String nome = request.getParameter("nomePerfil");
				String email = request.getParameter("email");
				Adm adm = new Adm();
				adm.setIdUsuario(id);
				adm.setNome(nome);
				adm.setEmail(email);
				System.out.println(adm.toString());
				new ServiceAdm().edit(adm);
	
				
			request.setAttribute("msg", "<div id='confirm' class='alert alert-success text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-up' style='font-size:20px;'></span> Perfil Alterado com sucesso, Efetue o login novamente Para ver os resultados</div>");
			
			}else {
				request.setAttribute("msg", "<div id='confirm' class='alert alert-info text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-up' style='font-size:20px;'></span> Senha invalida</div>");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "<div id='confirm' class='alert alert-danger text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-up' style='font-size:20px;'></span> Senha invalida</div>");
			System.out.println(e.getMessage());
		}finally {
			request.getRequestDispatcher("perfil.jsp").forward(request, response);
		}
	}
	

}
