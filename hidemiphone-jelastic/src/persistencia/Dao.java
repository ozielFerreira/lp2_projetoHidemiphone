package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class Dao {
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	/*
	 //mudar o banco de dados quanto estiver hospedado
	private static final String URL  = "jdbc:mysql://node162586-hidemiiphone.jelasticlw.com.br/hidemiphone_loja";//<-----------alterar nomeDoBanco
	private static final String USER  = "root";
	private static final String PASS  = "RYVyyg81324";
	*/
	
	private static final String URL  = "jdbc:mysql://localhost:3306/hidemiphone_loja";//<-----------alterar nomeDoBanco
	private static final String USER  = "root";
	private static final String PASS  = "";
	
	protected void abrirConexao() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(URL,USER,PASS);
 
	}
	
	protected void fecharConexao() throws Exception{
		con.close();

	}
	

}
