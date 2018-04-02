package entidade;

import java.io.Serializable;

public class Adm extends Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private String senha;

	public Adm() {
		// TODO Auto-generated constructor stub
	}

	public Adm(String senha) {
		super();
		this.senha = senha;
	}

	public Adm(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adm other = (Adm) obj;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Adm [senha=" + senha + ",email=" + email + ",nome=" + nome + "]";
	}

}
