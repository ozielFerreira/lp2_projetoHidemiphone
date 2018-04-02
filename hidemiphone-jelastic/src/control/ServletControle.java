package control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import email.EnvioEmail;
import entidade.Cliente;
import entidade.Endereco;
import entidade.Orcamento;
import entidade.Telefone;

import pdf.GeradorPdf;
import util.Upload;

@WebServlet({ "/orcamento","/contato" })
@MultipartConfig
public class ServletControle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletControle() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals("/orcamento")) {
			orcamento(request, response);
		}
		if (request.getServletPath().equals("/contato")) {
			contato(request, response);
		}
	}

	protected void contato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		try {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String telefone = request.getParameter("tel");
			String menssagem = request.getParameter("mensagem");
			EnvioEmail.htmlMail(request.getServletContext().getRealPath("/")+File.separator+"img"+File.separator, "mauriciomourams@gmail.com", "Fale Conosco", nome, email, telefone, menssagem);
			//email do hidemi que vai receber
			request.setAttribute("msg", "<script>$(document).ready(function() { \r\n" + 
					"window.location.href='#confirmc';\r\n" + 
					"});</script><div id='confirmc' class='alert alert-success text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-up' style='font-size:20px;'></span> Sua menssagem foi enviada com sucesso</div>");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute("msg", "<script>$(document).ready(function() { \r\n" + 
					"window.location.href='#confirmc';\r\n" + 
					"});</script><div id='confirmc' class='alert alert-danger text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-down' style='font-size:20px;'></span> Falha ao Enviar Menssagem</div>");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		}

	// método pra orcamento

	protected void orcamento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Telefone te = new Telefone(null, request.getParameter("telefone"));

		// cliente e telefone
		Cliente c = new Cliente();
		List<Telefone> lista = new ArrayList<Telefone>();

		lista.add(te);

		c.setNome(request.getParameter("nome"));
		c.setEmail(request.getParameter("email"));
		c.setTelefone(lista);

		// orcamento
		Orcamento o = new Orcamento();
		o.setIdAparelho(null);
		o.setNumdeSerie(request.getParameter("serie"));
		o.setEquipamento(request.getParameter("equipamento"));
		o.setModelo(request.getParameter("modelo"));
		o.setOrigem(request.getParameter("origem"));
		o.setCor(request.getParameter("cor"));
		o.setProblema(request.getParameter("problema"));
		o.setDescricao(request.getParameter("descricao"));
		o.setCliente(c);
		o.getCliente().setTelefone(lista);
		o.getCliente().setCep(request.getParameter("cep"));

		// endereco
		Endereco e = new Endereco(null, request.getParameter("rua"), request.getParameter("num"),
				request.getParameter("bairro"), request.getParameter("cidade"));

		o.getCliente().setEndereco(e);
		List<Orcamento> orc = new ArrayList<Orcamento>();
		orc.add(o);
		System.out.println(o.toString());

		try {
			String path = request.getServletContext().getRealPath("/") + File.separator + "upFotos" + File.separator;
			System.out.println(o.toString());
			String frente = Upload.upload(request, response, request.getPart("frente"), path);
			String lateral = Upload.upload(request, response, request.getPart("lateral"), path);
			String verso = Upload.upload(request, response, request.getPart("verso"), path);

			//GeradorPdf.gerar(orc, request.getServletContext().getRealPath("pdf"));
			EnvioEmail.orcamento(request.getServletContext().getRealPath("/") + File.separator + "img" + File.separator,
					"mauriciomourams@gmail.com", "Orçamento", o, path + frente, path + lateral, path + verso);
//email do hidemi que vai receber
			request.setAttribute("message",
					"<script>$(document).ready(function() { \r\n" + 
					"window.location.href='#confirm';\r\n" + 
					"});</script><div id='confirm' class='alert alert-success text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-up' style='font-size:20px;'></span> Seu Orçamento foi enviado com sucesso, Aguarde a Resposta</div>");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			//apagar as fotos upadas depois que foram enviadas pra n lotar o serividor
			System.out.println(path);
			File l = new File(path + lateral);
			File f = new File(path + frente);
			File v = new File(path + verso);
			l.delete();
			v.delete();
			f.delete();
			//fim 
		} catch (Exception e1) {
			request.setAttribute("message",
					"<div id='confirm' class='alert alert-danger text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-up' style='font-size:20px;'></span> Falha ao enviar seu orçamento, tente novamente mais tarde</div>");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			e1.printStackTrace();
		}
	}

}
