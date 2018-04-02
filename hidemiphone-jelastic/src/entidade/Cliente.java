package entidade;

import java.io.Serializable;
import java.util.List;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idUsuario;
	protected String nome;
	protected String email;
	private List<Telefone> telefone;
	private String cep;
	private Endereco endereco;

	public Cliente() {

	}

	public Cliente(Long idUsuario, String nome, String email, List<Telefone> telefone, String cep, Endereco endereco) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cep = cep;
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return "Cliente [idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone
				+ ", cep=" + cep + ", endereco=" + endereco + "]";
	}

}
