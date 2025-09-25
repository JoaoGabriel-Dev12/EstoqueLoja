package com.lojavirtual.projetofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lojavirtual.projetofinal.connection.ConnectionFactory;
import com.lojavirtual.projetofinal.model.Usuario;

public class UsuarioDAO {
		
	ConnectionFactory connection = new ConnectionFactory();
	
	public void inserir(Usuario usuario) throws Exception {
		
		String sql = "INSERT INTO usuarios(nome, senha) VALUES (?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = connection.createConnectionMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getUsuario());
			pstm.setString(2, usuario.getSenha());
			
			pstm.execute();
			System.out.println("tudo certo");
		
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
	
	public List<Usuario> listar() throws Exception {
		
		String sql = "SELECT * FROM usuarios";
		
		List<Usuario> usuarios = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			conn = connection.createConnectionMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Usuario usuario = new Usuario();
				
				usuario.setId(rset.getInt("id"));
				usuario.setUsuario(rset.getString("nome"));
				
				usuarios.add(usuario);
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
		return usuarios;
	}
	
	public Usuario buscarPorId(int id) throws Exception {
		
		String sql = "SELECT * FROM usuarios WHERE id = ?";
		Usuario usuario = new Usuario();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = connection.createConnectionMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				int id_user = rset.getInt("id");
				String nome = rset.getString("nome");
				String senha = rset.getString("senha");
				
				usuario.setId(id_user);
				usuario.setUsuario(nome);
				usuario.setSenha(senha);
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
		return usuario;
		
	}
	
	public void atualizar(Usuario usuario) throws Exception {
		
		String sql = "UPDATE usuarios SET nome = ?, senha = ?" + 
		"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = connection.createConnectionMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getUsuario());
			pstm.setString(2, usuario.getSenha());
			
			pstm.setInt(3, usuario.getId());
			
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
		
		String sql = "DELETE FROM usuarios WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = connection.createConnectionMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			pstm.execute();
			
		}catch (Exception e){
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
