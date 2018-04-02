package control;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import email.EnvioEmail;
import entidade.Adm;
import service.ServiceAdm;

@WebServlet({ "/solicita", "/recovery" })
public class ServletRecupera extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletRecupera() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String token = UUID.randomUUID().toString();

		// HttpSession sessao = request.getSession();
		try {

			if (request.getServletPath().equalsIgnoreCase("/recovery")) {

				if (request.getParameter("token").equals(request.getSession().getAttribute("token"))) {
					String cod = String.valueOf(Long.toHexString(new Random().nextLong()));
					new EnvioEmail().esqueciSenha(request.getServletContext().getRealPath("/") + File.separator + "img"+ File.separator,
							"mauriciomourams@gmail.com", "Sua nova senha ",
							"sua nova senha é :  <br><strong>" + cod + "</strong>");

					request.setAttribute("conf",
							"<div id='conf' class='alert alert-info'><button type='button' class='close' arial-label='true'>x</button>Uma nova senha foi gerada e enviada para seu E-mail, \n Efetue o login com ela</div>");

					new ServiceAdm().editSenha(new Adm("hidemiphone@gmail.com", cod));

					request.removeAttribute("token");
					request.getSession().setAttribute("trocaSenha", Boolean.TRUE);
					request.getRequestDispatcher("admin.jsp").forward(request, response);

//					System.out.println(" senha é :" + cod);

				}
			} else {
				System.out.println("erro");
			}

			if (request.getServletPath().equalsIgnoreCase("/solicita")) {

				new EnvioEmail().esqueciSenha(request.getServletContext().getRealPath("/") + File.separator + "img"+File.separator,
						"mauriciomourams@gmail.com", "Esqueci minha senha",
						"Esqueceu sua senha <a href='http://localhost:8080/hidemiphone_jelastic/recovery?token="
								+ token + "'>Clique aqui</a>");//site do hidemi e email do hidemi para recuperação de senha

				request.getSession().setAttribute("token", token);
//				System.out.println(token);
				request.setAttribute("conf",
						"<div id='conf' class='alert alert-success'><button type='button' class='close' arial-label='true'>x</button>Confirmação foi enviada com sucesso, Verifique o seu E-mail</div>");
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			} else {

				request.setAttribute("conf",
						"<div id='conf' class='alert alert-danger'><button type='button' class='close' arial-label='Close'>x</button>Erro ai Enviar a confirmação, Verifique se o E-mail é valido</div>");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
