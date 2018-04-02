package entidade;

import java.io.Serializable;
import java.util.List;

public class Servico  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private Long Codigo;
	private String nome;
	private String foto;
	private List<DescricaoServico> desc;
	private String categoria;
	
	public Servico() {
		// TODO Auto-generated constructor stub
	}

	public Servico(Long codigo, String nome,String foto) {
		super();
		this.Codigo = codigo;
		this.nome = nome;
		this.foto = foto;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
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
		Servico other = (Servico) obj;
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		return true;
	}


	
	

	public List<DescricaoServico> getDesc() {
		return desc;
	}

	public void setDesc(List<DescricaoServico> desc) {
		this.desc = desc;
	}

	public Long getCodigo() {
		return Codigo;
	}

	public void setCodigo(Long Codigo) {
		this.Codigo = Codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Servico [Codigo=" + Codigo + ", nome=" + nome + ", foto=" + foto + ", desc=" + desc + ", categoria="
				+ categoria + "]";
	}

	


	}

	
	


