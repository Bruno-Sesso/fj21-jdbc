package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jbdc.dao.ContatoDao;
import br.com.caelum.jdb.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) throws SQLException {
		
		// pronto para gravar
		Contato contato = new Contato();
		contato.setNome("Bruno Brand�o Mendes Sesso");
		contato.setEmail("bruno.mendes.sesso@gmail.com");
		contato.setEndereco("Minha casa numero x");
		contato.setDataNascimento(Calendar.getInstance());
		
		//grave nessa conex�o!!!
		ContatoDao dao = new ContatoDao();
		
		//m�todo elegante
		dao.adiciona(contato);
		
		System.out.println("Gravado!");
		System.out.println("Nome" + contato.getNome());
		System.out.println("Email" + contato.getEmail());
		System.out.println("Endere�o" + contato.getEndereco());
		System.out.println("Data" + contato.getDataNascimento());
	}

}
