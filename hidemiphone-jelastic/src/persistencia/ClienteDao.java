
package persistencia;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidade.Cliente;
import entidade.Endereco;
import entidade.Telefone;

public class ClienteDao extends Dao {

	public Cliente save(Cliente c) throws Exception {
		abrirConexao();

		if (c.getIdUsuario() == null) {
			stmt = con.prepareStatement("INSERT INTO tb_cliente VALUES (null,?,?,?)", Statement.RETURN_GENERATED_KEYS);

		} else {
			stmt = con.prepareStatement("UPDATE tb_cliente set nome = ?, email = ?, cep = ? where idCliente = ?");
		}
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getEmail());
		stmt.setString(3, c.getCep());

		if (c.getIdUsuario() != null) {
			stmt.setLong(4, c.getIdUsuario());
			stmt.execute();
		}
		if (c.getIdUsuario() == null) {
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				c.setIdUsuario(rs.getLong(1));
			}
		}

		stmt.close();

		if (c.getEndereco().getIdEndereco() == null) {
			stmt = con.prepareStatement("INSERT INTO tb_endereco VALUES (null, ?, ?, ?, ?, ?)");
		} else {
			stmt = con.prepareStatement(
					"UPDATE tb_endereco SET endereco = ? ,numero = ?, bairro = ? ,cidade = ? WHERE idEndereco = ?");
		}

		stmt.setString(1, c.getEndereco().getLogradouro());
		stmt.setString(2, c.getEndereco().getNumero());

		stmt.setString(3, c.getEndereco().getBairro());
		stmt.setString(4, c.getEndereco().getCidade());

		if (c.getEndereco().getIdEndereco() != null) {
			stmt.setLong(5, c.getEndereco().getIdEndereco());
		} else {
			stmt.setLong(5, c.getIdUsuario());
		}

		stmt.execute();
		
		for (Telefone telefone : c.getTelefone()) {
			saveTel(c.getIdUsuario(), telefone);
		}

		stmt.close();

		fecharConexao();
		return c;
	}

	public List<Telefone> getListaTel(Long id) throws Exception {
		abrirConexao();
		String sql = "";
		 
		sql = "select lista_telefonica.idTel,lista_telefonica.telefone from lista_telefonica, tb_cliente WHERE lista_telefonica.cliente_id = tb_cliente.idCliente and tb_cliente.idCliente = ?";
		
		stmt = con.prepareStatement(sql);
		stmt.setLong(1, id);
	
		rs = stmt.executeQuery();
		List<Telefone> list = new ArrayList<Telefone>();
		while (rs.next()) {
			Telefone t = new Telefone(rs.getInt(1), rs.getString(2));
			list.add(t);
		}
		rs.close();
		stmt.close();

		return list;

	}

	public void saveTel(Long id, Telefone t) throws Exception {
abrirConexao();
		if (t.getId() == null) {
			stmt = con.prepareStatement("INSERT INTO lista_telefonica values(null, ?, ?)");
			stmt.setLong(1, id);
			stmt.setString(2, t.getNumero());
		} else {
			stmt = con.prepareStatement("UPDATE lista_telefonica SET telefone = ? WHERE idTel = ?");
			stmt.setString(1, t.getNumero());
			stmt.setLong(2, t.getId());
		}

		if (t.getId() != null) {
			stmt.setLong(2, t.getId());
		}
		stmt.execute();
		stmt.close();
		fecharConexao();
		
	}

	public List<Cliente> listaCliente() throws Exception {
		abrirConexao();

		stmt = con.prepareStatement(
				"SELECT c.idCliente, c.nome, c.email, c.cep,e.idEndereco, e.endereco, e.numero, e.bairro, e.cidade FROM tb_cliente c INNER JOIN tb_endereco e ON e.endereco_fk = c.idCliente ");
		rs = stmt.executeQuery();

		List<Cliente> lista = new ArrayList<Cliente>();
		List<Telefone> listaTel = new ArrayList<Telefone>();
		while (rs.next()) {
			Cliente c = new Cliente();

			c.setIdUsuario(rs.getLong("c.idCliente"));
			c.setNome(rs.getString("c.nome"));
			c.setEmail(rs.getString("c.email"));
			c.setCep(rs.getString("c.cep"));

			Endereco e = new Endereco();

			e.setIdEndereco(rs.getLong("e.idEndereco"));
			e.setLogradouro(rs.getString("e.endereco"));
			e.setNumero(rs.getString("e.numero"));
			e.setBairro(rs.getString("e.bairro"));
			e.setCidade(rs.getString("e.cidade"));

			c.setTelefone(listaTel);
			c.setEndereco(e);
			lista.add(c);

		}
		rs.close();
		stmt.close();
		fecharConexao();
		return lista;
	}

	public Cliente selectById(Long id) throws Exception {
		abrirConexao();

		stmt = con.prepareStatement(
				"SELECT c.idCliente, c.nome, c.email,t.idTel ,t.telefone, c.cep,e.idEndereco, e.endereco, e.numero, e.bairro, e.cidade FROM tb_cliente c INNER JOIN lista_telefonica t ON t.cliente_id = c.idCliente INNER JOIN tb_endereco e ON e.endereco_fk = c.idCliente where c.idCliente = ?");

		stmt.setLong(1, id);
		rs = stmt.executeQuery();

		Cliente c = null;
		List<Telefone> listaTel = new ArrayList<Telefone>();
		if (rs.next()) {
			c = new Cliente();

			c.setIdUsuario(rs.getLong("c.idCliente"));
			c.setNome(rs.getString("c.nome"));
			c.setEmail(rs.getString("c.email"));
			c.setCep(rs.getString("c.cep"));

			Telefone t = new Telefone();

			t.setId(rs.getInt("t.idTel"));
			t.setNumero(rs.getString("t.telefone"));
			listaTel.add(t);

			Endereco e = new Endereco();

			e.setIdEndereco(rs.getLong("e.idEndereco"));
			e.setLogradouro(rs.getString("e.endereco"));
			e.setNumero(rs.getString("e.numero"));
			e.setBairro(rs.getString("e.bairro"));
			e.setCidade(rs.getString("e.cidade"));

			c.setTelefone(listaTel);
			c.setEndereco(e);

		}
		rs.close();
		stmt.close();
		fecharConexao();
		return c;
	}

	public void deleteT(Long id) throws Exception {
		abrirConexao();
		stmt = con.prepareStatement("delete from lista_telefonica where cliente_id = ?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		fecharConexao();

	}
	public void deleteTelefone(Integer i) throws Exception {
		abrirConexao();
		stmt = con.prepareStatement("delete from lista_telefonica where idTel = ?");
		stmt.setInt(1, i);
		stmt.execute();
		stmt.close();
		fecharConexao();

	}

	public void deleteE(Long id) throws Exception {
		abrirConexao();
		stmt = con.prepareStatement("delete from tb_endereco where endereco_fk = ?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		fecharConexao();

	}

	public void deleteC(Long id) throws Exception {
		abrirConexao();
		stmt = con.prepareStatement("delete from tb_cliente where idCliente = ?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		fecharConexao();

	}

}


