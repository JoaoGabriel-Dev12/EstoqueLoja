package com.lojavirtual.projetofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lojavirtual.projetofinal.connection.ConnectionFactory;
import com.lojavirtual.projetofinal.model.Fornecedor;

public class FornecedorDAO {
	
	private ConnectionFactory connection = new ConnectionFactory();
	
	public void inserir(Fornecedor fornecedor) throws SQLException {
		
		String sql = "INSERT INTO fornecedores(nome, cnpj, telefone) VALUES(?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			
			conn = connection.createConnectionMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, fornecedor.getNome());
			pstm.setString(2, fornecedor.getCnpj());
			pstm.setString(3, fornecedor.getTelefone());
			
			pstm.execute();
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstm != null) {
				pstm.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public List<Fornecedor> listar() throws SQLException {
		
		String sql = "SELECT * FROM fornecedores";
		
		List<Fornecedor> fornecedores = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			
			conn = connection.createConnectionMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Fornecedor fornecedor = new Fornecedor();
				
				fornecedor.setId(rset.getInt("id"));
				fornecedor.setNome(rset.getString("nome"));
				fornecedor.setCnpj(rset.getString("cnpj"));
				fornecedor.setTelefone(rset.getString("telefone"));
				
				fornecedores.add(fornecedor);
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset != null) {
				rset.close();
			}
			
			if(pstm != null) {
				pstm.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		}
		return fornecedores;
 	}
	
	public Fornecedor buscarPorId(int id) throws SQLException {
		
		String sql = "SELECT * FROM fornecedores WHERE id = ?";
		
		Fornecedor fornecedor = new Fornecedor();
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			
			conn = connection.createConnectionMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				int id_fornecedor = rset.getInt("id");
				String nome = rset.getString("nome");
				String cnpj = rset.getString("cnpj");
				String telefone = rset.getString("telefone");
				
				fornecedor.setId(id_fornecedor);
				fornecedor.setNome(nome);
				fornecedor.setCnpj(cnpj);
				fornecedor.setTelefone(telefone);
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset != null) {
				rset.close();
			}
			if(pstm != null) {
				pstm.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		return fornecedor;
	}
	
	public void atualizar(Fornecedor fornecedor) throws Exception {
		
		String sql = "UPDATE fornecedores SET nome = ?, cnpj = ?, telefone = ? WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = connection.createConnectionMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, fornecedor.getNome());
			pstm.setString(2, fornecedor.getCnpj());
			pstm.setString(3, fornecedor.getTelefone());
			
			pstm.setInt(4, fornecedor.getId());
			pstm.execute();
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstm != null) {
				pstm.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public void deletar(int id) throws Exception {
		
		String sql = "DELETE FROM fornecedores WHERE = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = connection.createConnectionMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstm != null) {
				pstm.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
	}
}
