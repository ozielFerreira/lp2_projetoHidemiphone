package entidade;

import java.io.Serializable;

public class Produto  implements Serializable  {

	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String nome;
	private String foto;
	private String descricao;
	private Double preco;
	private String categoria;
	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(Long codigo, String nome, String foto, String descricao, Double preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.foto = foto;
		this.descricao = descricao;
		this.preco = preco;
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
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", foto=" + foto + ", descricao=" + descricao
				+ ", preco=" + preco + ", categoria=" + categoria + "]";
	}

	
	
	
	
	
	
}
