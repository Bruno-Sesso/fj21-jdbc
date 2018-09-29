package br.com.caelum.jbdc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.jdb.modelo.Contato;
import br.com.caelum.jdbc.teste.ConnectionFactory;

public class ContatoDao {
	// a conexão com o banco de dados
	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) throws SQLException{
		String sql = "INSERT INTO contatos " +
				"(nome,email,endereco,dataNascimento) " +
				"values (?,?,?,?)";
			
		try {
			
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
