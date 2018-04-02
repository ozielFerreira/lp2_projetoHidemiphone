package service;

import java.io.Serializable;
import java.util.List;

import entidade.Cliente;
import entidade.Telefone;
import persistencia.ClienteDao;

public class ServiceCliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	ClienteDao cd;
	public ServiceCliente() {
		cd = new ClienteDao();
	}
	
	
	public List<Cliente> getListCliente() throws Exception{
		return cd.listaCliente();
	}
	public boolean save(Cliente c) throws Exception{
		cd.save(c);
		return Boolean.TRUE;
	}
	public Cliente selectById(Long id) throws Exception{
		return cd.selectById(id);
		
	}
	public List<Telefone> getListaTelefonica(Long id) throws Exception{
		return cd.getListaTel(id);
		
	}
	
	public boolean saveTel(Cliente c) throws Exception{
//		cd.saveTel(c);
		return Boolean.TRUE;
	}
	public boolean deleteT(Long id) throws Exception{
		cd.deleteT(id);
		return Boolean.TRUE;
	}
	public boolean deleteE(Long id) throws Exception{
		cd.deleteE(id);
		return Boolean.TRUE;
	}
	public boolean deleteC(Long id) throws Exception{
		cd.deleteC(id);
		return Boolean.TRUE;
	}

}
