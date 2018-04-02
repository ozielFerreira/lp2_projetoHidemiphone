package entidade;

import java.io.Serializable;

public class DescricaoServico implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String descricao;
	private Double valor;
	
	
	public DescricaoServico() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		DescricaoServico other = (DescricaoServico) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "DescricaoServico [codigo=" + codigo + ", descricao=" + descricao + ", valor=" + valor + "]";
	}
	
	
	
	
	
}
