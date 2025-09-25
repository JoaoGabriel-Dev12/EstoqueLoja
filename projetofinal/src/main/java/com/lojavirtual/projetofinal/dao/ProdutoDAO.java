package com.lojavirtual.projetofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lojavirtual.projetofinal.connection.ConnectionFactory;
import com.lojavirtual.projetofinal.model.Produto;

public class ProdutoDAO {
	
	private ConnectionFactory connection = new ConnectionFactory();
	
	public void inserir(Produto produto) throws Exception {
		
		String sql = "INSERT INTO produtos(nome, codigo, preco, quantidade, id_fornecedor) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = connection.createConnectionMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getCodigo());
			pstm.setDouble(3, produto.getPreco());
			pstm.setInt(4, produto.getQuantidade());
			pstm.setInt(5, produto.getId_fornecedor());
			
			pstm.execute();
		
		}catch(Exception e) {
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
	
	public List<Produto> listar() throws Exception {
		
		String sql = "SELECT * FROM produtos";
		
		List<Produto> produtos = new ArrayList<Produto>();
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = connection.createConnectionMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Produto produto = new Produto();
				produto.setId(rset.getInt("id"));
				produto.setNome(rset.getString("nome"));
				produto.setCodigo(rset.getString("codigo"));
				produto.setPreco(rset.getDouble("preco"));
				produto.setQuantidade(rset.getInt("quantidade"));
				produto.setId_fornecedor(rset.getInt("id_fornecedor"));
				
				produtos.add(produto);
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
		return produtos;
	}
	
}
