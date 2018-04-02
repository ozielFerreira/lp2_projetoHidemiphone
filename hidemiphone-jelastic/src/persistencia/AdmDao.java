package persistencia;

import entidade.Adm;

public class AdmDao extends Dao {

	public void atualizarSenha(Adm ad) throws Exception {
		abrirConexao();
		stmt = con.prepareStatement("update admin set senha = md5(?) where email = ?");
		stmt.setString(1, ad.getSenha());
		stmt.setString(2, ad.getEmail());
		stmt.execute();
		stmt.close();
		fecharConexao();
	}

	public Adm login(String email, String senha) throws Exception {
		abrirConexao();

		stmt = con.prepareStatement("select idAdmin, nome, email from admin where email = ? and senha = md5(?)");
		stmt.setString(1, email);
		stmt.setString(2, senha);
		rs = stmt.executeQuery();

		Adm ad = null;

		if (rs.next()) {
			ad = new Adm();
			ad.setIdUsuario(rs.getLong("idAdmin"));
			ad.setNome(rs.getString("nome"));
			ad.setEmail(rs.getString("email"));
		}

		return ad;

	}

	public boolean verificarEmail(String email) throws Exception {
		abrirConexao();

		stmt = con.prepareStatement("select idAdmin, nome, email from admin where email = ?");
		stmt.setString(1, email);

		rs = stmt.executeQuery();

		boolean existe = false;

		if (rs.next()) {
			existe = true;
		} else
			existe = false;

		return existe;
	}

	public Adm buscaPorEmail(String email) throws Exception {
		abrirConexao();

		stmt = con.prepareStatement("select idAdmin, nome, email from admin where email = ?");
		stmt.setString(1, email);

		rs = stmt.executeQuery();

		Adm ad = null;

		if (rs.next()) {
			ad = new Adm();
			ad.setIdUsuario(rs.getLong("idAdmin"));
			ad.setNome(rs.getString("nome"));
			ad.setEmail(rs.getString("email"));
		}

		return ad;

	}

	public boolean verificaSenha(String senha) throws Exception {
		abrirConexao();

		stmt = con.prepareStatement("select idAdmin, nome, email from admin where senha = md5(?)");
		stmt.setString(1, senha);

		rs = stmt.executeQuery();
		boolean success = false;

		if (rs.next()) {
			success = true;
		}

		stmt.close();
		rs.close();
		return success;

	}

	public Adm selectAdmin() throws Exception {
		abrirConexao();

		stmt = con.prepareStatement("select idAdmin, nome, email from admin");

		rs = stmt.executeQuery();

		Adm ad = null;

		if (rs.next()) {
			ad = new Adm();
			ad.setIdUsuario(rs.getLong("idAdmin"));
			ad.setNome(rs.getString("nome"));
			ad.setEmail(rs.getString("email"));
		}

		return ad;

	}
	public void update(Adm ad) throws Exception{
		abrirConexao();
		stmt = con.prepareStatement("UPDATE `admin` SET email=?, nome = ? WHERE idAdmin = ?");
		stmt.setString(1, ad.getEmail());
		stmt.setString(2, ad.getNome());
		stmt.setLong(3, ad.getIdUsuario());
		stmt.execute();
		stmt.close();
		fecharConexao();

	}
	

}
