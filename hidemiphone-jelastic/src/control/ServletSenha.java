package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidade.Adm;
import service.ServiceAdm;

@WebServlet({"/ServletSenha","/admin/mudar_senha"})
public class ServletSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletSenha() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		try {
			ServiceAdm sd = new ServiceAdm();
			Long id = Long.parseLong(request.getParameter("id"));
			String novaSenha = request.getParameter("senhaNova");
			String confSenha = request.getParameter("confirmarSenhaNova");
			
			if(sd.verificaSenha(request.getParameter("senhaAtual")) == true) {
				if(novaSenha.equals(confSenha)) {
				Adm ad = (Adm) request.getSession().getAttribute("admin");
				ad.setSenha(novaSenha);
				ad.setIdUsuario(id);
				
				new ServiceAdm().editSenha(ad);
				msg = "<div id='confirm' class='alert alert-success text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-up' style='font-size:20px;'></span> Perfil Alterado com sucesso, Efetue o login novamente Para ver os resultados</div>";
				}else {
					msg = "<div id='confirm' class='alert alert-info text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-up' style='font-size:20px;'></span> Confirmação da senha invalida</div>";
				}
			}else {
				msg = "<div id='confirm' class='alert alert-danger text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-up' style='font-size:20px;'></span> Senha atual Incorreta</div>";

			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("perfil.jsp").forward(request, response);
		}
	}

}
