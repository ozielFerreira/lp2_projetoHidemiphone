package control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.pdf.codec.Base64.InputStream;

import entidade.Produto;
import service.ServiceProduto;
import util.Upload;

@WebServlet({ "/admin/cadastrar_produto", "/admin/editar", "/admin/atualizar", "/admin/excluir" })
@MultipartConfig
public class ControlePainelAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControlePainelAdmin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getServletPath();
		if (url.equalsIgnoreCase("/admin/editar")) {
			selecionarProduto(request, response);
		} else if (url.equals("/admin/excluir")) {
			delete(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath();
		if (url.equalsIgnoreCase("/admin/cadastrar_produto")) {
			cadastrarProduto(request, response);
		} else if (url.equals("/admin/atualizar")) {
			atualizar(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	private void cadastrarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nomeProd = request.getParameter("nomeProd");
			String categoria = request.getParameter("cat");
			// Salvar os dados do formulário

			String path = getServletContext().getRealPath("/upFotos") + "//";
			System.out.println(path);
			String descricaoProd = request.getParameter("descricaoProd");
			String preco = request.getParameter("preco");

			preco = preco.replace(".", "");
			preco = preco.replace(',','.');
			preco = preco.replace("R$", "");

			Produto prod = new Produto();
			String imagem_produto = Upload.upload(request, response, request.getPart("imagem_produto"), path);
			prod.setNome(nomeProd);
			prod.setFoto(imagem_produto);
			prod.setDescricao(descricaoProd);
			prod.setPreco(new Double(preco));
			prod.setCategoria(categoria);
			new ServiceProduto().save(prod);

			request.setAttribute("msg",
					"<div class='alert alert-success text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-up' style='font-size:20px;'></span> Cadastro Realizado com Sucesso!</div>");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg",
					"<div class='alert alert-danger text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-down' style='font-size:20px;'></span> Falha ao Cadastrar!</div>");
		} finally {
			request.getRequestDispatcher("cadastrar_produto.jsp").forward(request, response);
		}
	}

	private void selecionarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String cod = request.getParameter("cod");
			ServiceProduto prod = new ServiceProduto();

			request.setAttribute("produto", prod.selectbyId(Long.parseLong(cod)));
			request.getRequestDispatcher("editar_produto.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void atualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nomeProd = request.getParameter("nome");

			// Salvar os dados do formulário

			String path = getServletContext().getRealPath("/upFotos") + "//";
			System.out.println(path);
			String descricaoProd = request.getParameter("descricao");
			String preco = request.getParameter("preco");
			
			Produto prod = new Produto();
			preco = preco.replace(".", "");
			preco = preco.replace(',','.');
			preco = preco.replace("R$", "");

			String imagem_produto = "";
			
			if(request.getPart("imagem_produto").getSize() == 0) {
				imagem_produto = request.getParameter("foto");
			}else {
				File f = new File(path+request.getParameter("foto"));
				f.delete();
				imagem_produto = Upload.upload(request, response, request.getPart("imagem_produto"),path);
	
			}
			
			prod.setCodigo(Long.parseLong(request.getParameter("id")));
			prod.setNome(nomeProd);
			prod.setFoto(imagem_produto);
			prod.setDescricao(descricaoProd);

			prod.setPreco(Double.parseDouble(preco));
			System.out.println(prod.toString());
			new ServiceProduto().save(prod);

			request.setAttribute("msg",
					"<div class='alert alert-success text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-up' style='font-size:20px;'></span> Atualização Realizada com Sucesso!</div>");
			request.getRequestDispatcher("produto.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("msg",
					"<div class='alert alert-danger text-center' id='div'><button type='button' class='close' data-dismiss='alert'>×</button><span class='glyphicon glyphicon-thumbs-up' style='font-size:20px;'></span> Falha ao Realizar atualização!</div>");
			System.out.println(e.getMessage());
		}

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("cod");
		try {
			String path = getServletContext().getRealPath("/upFotos") + "//";

			File f = new File(path+request.getParameter("f"));
			f.delete();
			new ServiceProduto().delete(Long.parseLong(id));
			response.sendRedirect("produto.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
