package service;

import java.io.Serializable;
import java.util.List;

import entidade.Produto;
import persistencia.ProdutoDao;

public class ServiceProduto implements Serializable{
	
	
	private ProdutoDao pd;
	
	private static final long serialVersionUID = 1L;
	
	public ServiceProduto() {
		pd = new ProdutoDao();
	}
	
	
	public boolean save(Produto p) throws Exception{
		pd.inserirProduto(p);
		return Boolean.TRUE;
	}
	
	public List<Produto> list() throws Exception{
		return pd.listarProduto();
	}
	
	public Produto selectbyId(Long id) throws Exception{
		return pd.buscarProdutoPorId(id);
	}
	
	public boolean delete(Long id) throws Exception{
		pd.excluirProduto(id);;
		return Boolean.TRUE;
	}
	
}
