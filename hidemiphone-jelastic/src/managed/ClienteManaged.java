package managed;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.Bean1;

import entidade.Cliente;
import service.ServiceCliente;

public class ClienteManaged extends Bean1{
	private List<Cliente> listaCli;

	public List<Cliente> getListaCli() throws Exception{
		ServiceCliente sc = new ServiceCliente();
		
		return sc.getListCliente();
	}

	public void setListaCli(List<Cliente> listaCli) {
		this.listaCli = listaCli;
	}
	
	
}
