package managed;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.Bean1;

import entidade.Telefone;
import persistencia.ClienteDao;
import service.ServiceCliente;

public class TelefoneManaged extends Bean1{

	private List<Telefone> listaTel;

	public List<Telefone> getListaTel(Long id) throws Exception {
		ServiceCliente c = new ServiceCliente();
		return c.getListaTelefonica(id);
	}

	public void setListaTel(List<Telefone> listaTel) {
		this.listaTel = listaTel;
	}
	
}
