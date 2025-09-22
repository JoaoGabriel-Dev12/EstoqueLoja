package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {
	
	// CRUD
	// Create, Read, update, delete
	
	public void save(Contato contato) {
		
		String sql = "INSERT INTO contatos(nome, idade, dataCadastro) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			// Cria conexão com o BD
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			pstm.execute();
			System.out.println("Tudo certo!");
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public List<Contato> getContatos(){
		
		String sql = "SELECT * FROM contatos";
		
		List<Contato> contatos = new ArrayList<Contato>();
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			 conn = ConnectionFactory.createConnectionToMySQL();
			 pstm = conn.prepareStatement(sql);
			 
			 rset = pstm.executeQuery();
			 
			 while (rset.next()) {
				 Contato contato = new Contato();
				 
				 contato.setId(rset.getInt("id"));
				 contato.setNome(rset.getString("nome"));
				 contato.setIdade(rset.getInt("idade"));
				 contato.setDataCadastro(rset.getDate("dataCadastro"));
				 
				 contatos.add(contato);
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rset != null) {
					rset.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contatos;
	}
}
