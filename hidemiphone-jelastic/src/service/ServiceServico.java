package service;

import java.io.Serializable;
import java.util.List;

import entidade.DescricaoServico;
import entidade.Servico;
import persistencia.ServicoDao;

public class ServiceServico implements Serializable{
	
	
	private ServicoDao sv;
	
	private static final long serialVersionUID = 1L;
	
	public ServiceServico() {
		sv = new ServicoDao();
	}
	
	
	public boolean save(Servico s) throws Exception{
		sv.inserirServico(s);
		return Boolean.TRUE;
	}
	
	

	
	public boolean delete(Long id) throws Exception{
		sv.excluirServico(id);;
		return Boolean.TRUE;
	}
	
	public List<Servico> getListServico() throws Exception{
		return sv.listarServ();
	}
	
	public Servico SelectById(Long id) throws Exception{
		return sv.selectById(id);
	}
	public boolean deleteDesc(Long id) throws Exception{
		sv.excluirDesc(id);;
		return Boolean.TRUE;
	}
	public List<DescricaoServico> listDesc(Long id) throws Exception{
		return sv.listarDesc(id);
	}
	
	
	
	
	public List<Servico> listCategoriaServ(String categoria) throws Exception{
		return sv.listaCategoriaServico(categoria);
	}
	
	
}