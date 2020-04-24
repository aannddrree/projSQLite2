package br.com.projsqlite.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionSQLite {
	
	private Connection conexao;
	private Statement statement;
	
	public ConnectionSQLite() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		conexao = DriverManager.getConnection("jdbc:sqlite:C:\\tmp\\dbaulasqlite.db");
		statement = conexao.createStatement();
		conexao.setAutoCommit(true);
		System.out.println("Conectou!");
	}
	
	public void desconectar() {		
		try {
			conexao.close();
			System.out.println("Conexão fechada!");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	//INSERT / UPDATE / DELETE
	public void exec (String sql) throws SQLException {
		statement.execute(sql);
	}
	
	//SELECT
	public ResultSet execComRetorno(String sql) throws SQLException {
		return statement.executeQuery(sql);
	}
}

