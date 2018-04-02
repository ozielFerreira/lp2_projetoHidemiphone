package entidade;

import java.io.Serializable;

public class Telefone implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String numero;
	
	
	
	public Telefone() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Telefone(Integer id, String numero) {
		super();
		this.id = id;
		this.numero = numero;
		
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return numero  ;
	}
	
	
	
	
}
