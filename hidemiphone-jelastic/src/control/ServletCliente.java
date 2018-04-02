
package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidade.Cliente;
import entidade.Endereco;
import entidade.Telefone;
import persistencia.ClienteDao;
import service.ServiceCliente;

/**
 * Servlet implementation class ServletCliente2
 */
@WebServlet({ "/admin/cadastro", "/admin/editar_cliente", "/admin/atualizar_cliente", "/admin/deletar_cliente" })
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals("/admin/editar_cliente")) {
			select(request, response);
		}
		if (request.getServletPath().equals("/admin/deletar_cliente")) {
			delete(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals("/admin/cadastro")) {
			cadastrarCliente(request, response);
		}
		if (request.getServletPath().equals("/admin/atualizar_cliente")) {
			atualizarDados(request, response);
		}
	}

	protected void select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			Cliente c = new ServiceCliente().selectById(Long.parseLong(id));
			request.setAttribute("c", c);
			request.getRequestDispatcher("editar_cliente.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	protected void cadastrarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String[] valores = request.getParameterValues("telefone");
			List<Telefone> lista = new ArrayList<Telefone>();
			for (int i = 0; i < valores.length; i++) {
				Telefone t = new Telefone(null, valores[i]);
				lista.add(t);

			}
			Cliente c = new Cliente();
			c.setIdUsuario(null);
			c.setNome(request.getParameter("nome"));
			c.setEmail(request.getParameter("email"));
			c.setCep(request.getParameter("cep"));

			Endereco e = new Endereco();
			e.setIdEndereco(null);
			e.setLogradouro(request.getParameter("endereco"));
			e.setNumero(request.getParameter("numero"));
			e.setBairro(request.getParameter("bairro"));
			e.setCidade(request.getParameter("cidade"));
			c.setTelefone(lista);
			c.setEndereco(e);

			new ClienteDao().save(c);
			request.setAttribute("msg",
					"<div class='alert alert-success text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-up' style='font-size:20px;'></span> Cliente cadastrado com sucesso!</div");

			lista.clear();
		} catch (Exception e1) {
			request.setAttribute("msg",
					"<div class='alert alert-danger text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-down' style='font-size:20px;'></span> Falha ao cadastrar cliente !</div>");
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		} finally {
			request.getRequestDispatcher("cadastrar_cliente.jsp").forward(request, response);
		}
	}

	protected void atualizarDados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			List<Telefone> lista = new ArrayList<Telefone>();

			String[] ids = request.getParameterValues("idTel");
			Telefone t = null;

			Cliente c = new Cliente();
			c.setIdUsuario(Long.parseLong(request.getParameter("idUser")));
			c.setNome(request.getParameter("nome"));
			c.setEmail(request.getParameter("email"));
			c.setCep(request.getParameter("cep"));

			Endereco e = new Endereco();
			e.setIdEndereco(Long.parseLong(request.getParameter("idEnd")));
			e.setLogradouro(request.getParameter("endereco"));
			e.setNumero(request.getParameter("numero"));
			e.setBairro(request.getParameter("bairro"));
			e.setCidade(request.getParameter("cidade"));

			String[] valores = request.getParameterValues("telefone");
			for (int i = 0; i < valores.length; i++) {

				t = new Telefone(Integer.parseInt(ids[i]), valores[i]);

				t.getNumero().trim();
				lista.add(t);

				new ClienteDao().saveTel(c.getIdUsuario(), t);

				if (lista.contains(t)) {
					lista.remove(t);
				}

			}
			c.setEndereco(e);
			c.setTelefone(lista);
			new ServiceCliente().save(c);

			System.out.println(c.toString());
			request.setAttribute("msg",
					"<div class='alert alert-success text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-up' style='font-size:20px;'></span>Perfil editado com sucesso!</div");

		} catch (Exception e1) {
			request.setAttribute("msg",
					"<div class='alert alert-danger text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-down' style='font-size:20px;'></span> Falha ao editar cliente!</div>");
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		} finally {
			request.getRequestDispatcher("cliente.jsp").forward(request, response);
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = null;
		try {
			new ServiceCliente().deleteT(Long.parseLong(request.getParameter("id")));
			new ServiceCliente().deleteE(Long.parseLong(request.getParameter("id")));
			new ServiceCliente().deleteC(Long.parseLong(request.getParameter("id")));
			msg = "<div class='alert alert-success text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-up' style='font-size:20px;'></span> Cliente excluido com sucesso!</div>";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			msg = "<div class='alert alert-danger text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-down' style='font-size:20px;'></span> Falha ao deletar cliente!</div>";
		} finally {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("cliente.jsp").forward(request, response);
		}
	}
}
