package managed;

import java.util.List;
import org.apache.taglibs.standard.lang.jstl.test.Bean1;

import entidade.DescricaoServico;
import entidade.Servico;
import persistencia.ServicoDao;
import service.ServiceServico;

public class ServicoManaged extends Bean1 {

	private List<Servico> listaServ;
	private ServiceServico sv;

	public ServicoManaged() {
		sv = new ServiceServico();
	}

	public List<Servico> getListaServ() throws Exception {

		return sv.getListServico();
	}

	public void setListaServ(List<Servico> listaServ) {
		this.listaServ = listaServ;
	}

	public List<DescricaoServico> getListaDesc(Long id) throws Exception {

		return sv.listDesc(id);
	}

	
	
	
	public List<Servico> servicoIphone(String categoria) throws Exception {

		return sv.listCategoriaServ(categoria);
	}





}
