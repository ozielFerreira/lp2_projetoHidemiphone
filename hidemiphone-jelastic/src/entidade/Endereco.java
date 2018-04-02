package entidade;

import java.io.Serializable;

public class Endereco   implements Serializable   {

	
	private static final long serialVersionUID = 1L;
	
	private Long idEndereco ;
	private String endereco;
	private String numero;

	private String bairro;
	private String cidade;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public Endereco(Long idEndereco, String endereco, String numero, String bairro,
			String cidade) {
		super();
		this.idEndereco = idEndereco;
		this.endereco = endereco;
		this.numero = numero;
		
		this.bairro = bairro;
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEndereco == null) ? 0 : idEndereco.hashCode());
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
		Endereco other = (Endereco) obj;
		if (idEndereco == null) {
			if (other.idEndereco != null)
				return false;
		} else if (!idEndereco.equals(other.idEndereco))
			return false;
		return true;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getLogradouro() {
		return endereco;
	}

	public void setLogradouro(String logradouro) {
		this.endereco = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return   endereco + " ,"+numero+ ", " + bairro + ", " + cidade + "";
	}
	
	
}
