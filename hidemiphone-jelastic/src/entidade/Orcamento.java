package entidade;

import java.io.Serializable;

public class Orcamento extends Cliente implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private Long  idAparelho;
	private String numdeserie;
	private String Equipamento;
	private String Modelo;
	private String Origem;
	private String Cor;
	private String Problema;
	private String Descricao;
	private Cliente cliente;
	
	public Orcamento() {
		
	}

	public Orcamento(Long idAparelho, String numdeSerie, String equipamento, String modelo, String origem, String cor,
			String problema, String descricao) {
		super();
		this.idAparelho = idAparelho;
		numdeserie = numdeSerie;
		Equipamento = equipamento;
		Modelo = modelo;
		Origem = origem;
		Cor = cor;
		Problema = problema;
		Descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((idAparelho == null) ? 0 : idAparelho.hashCode());
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
		Orcamento other = (Orcamento) obj;
		if (idAparelho == null) {
			if (other.idAparelho != null)
				return false;
		} else if (!idAparelho.equals(other.idAparelho))
			return false;
		return true;
	}

	
	
	
	
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getIdAparelho() {
		return idAparelho;
	}

	public void setIdAparelho(Long idAparelho) {
		this.idAparelho = idAparelho;
	}

	public String getNumdeSerie() {
		return numdeserie;
	}

	public void setNumdeSerie(String numdeSerie) {
		numdeserie = numdeSerie;
	}

	public String getEquipamento() {
		return Equipamento;
	}

	public void setEquipamento(String equipamento) {
		Equipamento = equipamento;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public String getOrigem() {
		return Origem;
	}

	public void setOrigem(String origem) {
		Origem = origem;
	}

	public String getCor() {
		return Cor;
	}

	public void setCor(String cor) {
		Cor = cor;
	}

	public String getProblema() {
		return Problema;
	}

	public void setProblema(String problema) {
		Problema = problema;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	@Override
	public String toString() {
		return "Orcamento idAparelho=" + idAparelho + ", NumdeSerie=" + numdeserie + ", Equipamento=" + Equipamento
				+ ", Modelo=" + Modelo + ", Origem=" + Origem + ", Cor=" + Cor + ", Problema=" + Problema
				+ ", Descricao=" + Descricao + ", cliente=" + cliente + "";
	}	
	
	
	
	
	
	
	
	
}
