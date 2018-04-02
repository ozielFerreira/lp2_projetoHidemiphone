package persistencia;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidade.DescricaoServico;
import entidade.Servico;

public class ServicoDao extends Dao {
	
	

	public void inserirServico(Servico s) throws Exception {
		abrirConexao();

		if (s.getCodigo() == null) {
			stmt = con.prepareStatement("insert into tb_servico values (null,?,?,?)",Statement.RETURN_GENERATED_KEYS);
		} else {
			stmt = con.prepareStatement("update tb_servico set nomeServ = ?,imagem_servico = ? where idServico= ?");
		}

		stmt.setString(1, s.getNome());
		stmt.setString(2, s.getFoto());
		stmt.setString(3, s.getCategoria());
		if(s.getCodigo() != null) {
			stmt.setLong(3, s.getCodigo());
			stmt.execute();
		}
		if(s.getCodigo() == null){
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				s.setCodigo(rs.getLong(1));
				System.out.println(s.toString());
			}
		}
		for (DescricaoServico desc : s.getDesc()) {
			
		
		if(desc.getCodigo() == null) {
			stmt = con.prepareStatement("insert into tb_servico_descricao values(null,?,?,?)");
		}else {
			stmt = con.prepareStatement("update tb_servico_descricao set descricaoServ = ?, valorServ = ? where idServicoDescricao = ?");
		}
		stmt.setString(1, desc.getDescricao());
		stmt.setDouble(2, desc.getValor());
		
		if(desc.getCodigo() !=null) {
			stmt.setLong(3, desc.getCodigo());
			
		}else {
			stmt.setLong(3, s.getCodigo());
		}
		stmt.execute();
		}
		stmt.close();
		fecharConexao();
	}


	public void excluirServico(Long id) throws Exception {
		abrirConexao();

		stmt = con.prepareStatement("delete from tb_servico where idServico = ?");

		stmt.setLong(1, id);

		stmt.execute();
		stmt.close();
		fecharConexao();
	}
	
	public void excluirDesc(Long id) throws Exception {
		abrirConexao();

		stmt = con.prepareStatement("DELETE FROM tb_servico_descricao WHERE servico_desc_fk = ?");

		stmt.setLong(1, id);

		stmt.execute();
		stmt.close();
		fecharConexao();
	}
	public List<Servico> listarServ() throws Exception{
		abrirConexao();
		stmt = con.prepareStatement("SELECT * from tb_servico");
		rs = stmt.executeQuery();
		
		List<Servico> lista = new ArrayList<Servico>();
		
		while(rs.next()) {
			Servico s = new Servico();
			s.setCodigo(rs.getLong(1));
			s.setNome(rs.getString(2));
			s.setFoto(rs.getString(3));
			s.setCategoria(rs.getString(4));
			
			
			lista.add(s);
		}
		stmt.close();
		rs.close();
		
		fecharConexao();
		return lista;
	}
	
	public List<Servico> listaCategoriaServico(String categoria) throws Exception{
		abrirConexao();
		stmt = con.prepareStatement("SELECT * from tb_servico where categoria = ?");
		stmt.setString(1, categoria);
		rs = stmt.executeQuery();
		
		List<Servico> lista = new ArrayList<Servico>();
		
		while(rs.next()) {
			Servico s = new Servico();
			s.setCodigo(rs.getLong(1));
			s.setNome(rs.getString(2));
			s.setFoto(rs.getString(3));
			s.setCategoria(rs.getString(4));
			
			
			lista.add(s);
		}
		stmt.close();
		rs.close();
		
		fecharConexao();
		return lista;
	}
	
	
	public List<DescricaoServico> listarCategoriaDesc(Long id, String categoria) throws Exception{
		abrirConexao();
		stmt = con.prepareStatement("SELECT *from tb_servico t INNER JOIN tb_servico_descricao d on d.servico_desc_fk = t.idServico Where d.servico_desc_fk = ? and t.categoria = ?");
		stmt.setLong(1, id);
		stmt.setString(2, categoria);
		
		stmt.setLong(1, id);
		rs = stmt.executeQuery();
		
		
		List<DescricaoServico> lista = new ArrayList<DescricaoServico>();
		while(rs.next()) {
			DescricaoServico d = new DescricaoServico();
			d.setCodigo(rs.getLong(5));
			d.setDescricao(rs.getString(6));
			d.setValor(rs.getDouble(7));
			lista.add(d);
			
		}
		stmt.close();
		rs.close();
		
		fecharConexao();
		return lista;
	}
	
	public List<DescricaoServico> listarDesc(Long id) throws Exception{
		abrirConexao();
		stmt = con.prepareStatement("SELECT *from tb_servico t INNER JOIN tb_servico_descricao d on d.servico_desc_fk = t.idServico Where d.servico_desc_fk = ?");
		stmt.setLong(1, id);
		rs = stmt.executeQuery();
		
		
		List<DescricaoServico> lista = new ArrayList<DescricaoServico>();
		while(rs.next()) {
			DescricaoServico d = new DescricaoServico();
			d.setCodigo(rs.getLong(5));
			d.setDescricao(rs.getString(6));
			d.setValor(rs.getDouble(7));
			lista.add(d);
			
		}
		stmt.close();
		rs.close();
		
		fecharConexao();
		return lista;
	}
	
	public Servico selectById(Long id) throws Exception{
		abrirConexao();
		stmt = con.prepareStatement("SELECT *from tb_servico t INNER JOIN tb_servico_descricao d on d.servico_desc_fk = t.idServico Where t.idServico = ?");
		stmt.setLong(1, id);
		
		rs = stmt.executeQuery();
		
		Servico s = null;
		
		List<DescricaoServico> listad = new ArrayList<DescricaoServico>();
		if(rs.next()) {
			s = new Servico();
			s.setCodigo(rs.getLong(1));
			s.setNome(rs.getString(2));
			s.setFoto(rs.getString(3));
			s.setCategoria(rs.getString(4));
			
			DescricaoServico d = new DescricaoServico();
			d.setCodigo(rs.getLong(5));
			d.setDescricao(rs.getString(6));
			d.setValor(rs.getDouble(7));
			listad.add(d);
			s.setDesc(listad);
			
		}
		stmt.close();
		rs.close();
		
		fecharConexao();
		return s;
	}
	
	
public static void main(String[] args) throws Exception{
	System.out.println(new ServicoDao().listarDesc(8l));
}
	
	

}