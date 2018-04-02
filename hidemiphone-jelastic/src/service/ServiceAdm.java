package service;

import java.io.Serializable;

import entidade.Adm;
import persistencia.AdmDao;

public class ServiceAdm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private AdmDao ad;
	
	public ServiceAdm() {
		ad= new AdmDao();
	}
	
	public Adm buscarLogin(String email, String senha) throws Exception{
		return ad.login(email, senha);
	}
	
	public Adm sendByEmail(String email) throws Exception{
		return ad.buscaPorEmail(email);
	}
	public boolean editSenha(Adm a)throws Exception{
		ad.atualizarSenha(a);
		return Boolean.TRUE;
	}
	public boolean verificaSenha(String senha)  throws Exception{
		
		return ad.verificaSenha(senha);
	}
	public boolean edit(Adm adm)  throws Exception{
		ad.update(adm);
		return Boolean.TRUE;
	}
	
}

