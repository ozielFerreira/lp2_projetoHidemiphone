package managed;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.Bean1;
import entidade.Produto;
import persistencia.ProdutoDao;

public class ProdutoManaged extends Bean1{
 
 private List<Produto> listaProd;
 private ProdutoDao pd ;
 public ProdutoManaged() {
	  pd = new ProdutoDao();
}
 public List<Produto> getListaProd() throws Exception {
  
  
  return pd.listarProduto();
 }
 public void setListaProd(List<Produto> listaProd) {
  this.listaProd = listaProd;
 }
 public List<Produto> listariPhone() throws Exception{
	 return pd.listaCategoria("iPhone");
 }
 public List<Produto> listarAcessorios() throws Exception{
	 return pd.listaCategoria("Acessórios");
 }
 public List<Produto> listariPad() throws Exception{
	 return pd.listaCategoria("iPad");
 }
 public static void main(String[] args) {
	try {
		System.out.println(new ProdutoDao().listaCategoria("Acessorios"));
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}