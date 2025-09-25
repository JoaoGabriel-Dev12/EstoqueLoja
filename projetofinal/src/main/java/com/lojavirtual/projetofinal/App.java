package com.lojavirtual.projetofinal;

import com.lojavirtual.projetofinal.dao.FornecedorDAO;
import com.lojavirtual.projetofinal.dao.UsuarioDAO;
import com.lojavirtual.projetofinal.model.Fornecedor;
import com.lojavirtual.projetofinal.model.Usuario;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        
    	// Testes de uso!
    	
    	//UsuarioDAO userDao = new UsuarioDAO();
    	
    	// Aqui adiciona um usuario
    	//Usuario user = new Usuario("sabotado", "0987");
    	//userDao.inserir(user);
    	
    	// Altera os dados
    	//Usuario user = new Usuario("admin", "12345");
    	//user.setId(1);
    	
    	//userDao.atualizar(user);
    	
    	
    	// Deleta pelo id
    	//userDao.deletar(2);
    	
    	// Buscar usuario pelo id
    	
    	//Usuario user = userDao.buscarPorId(1);
    	//System.out.println(user.getId() + ". " + user.getUsuario() + " | " + user.getSenha());
    	
    	// Teste de FornecedorDAO
    	
    	FornecedorDAO forneDao = new FornecedorDAO();
    	Fornecedor fornecedor = new Fornecedor();
    	//forneDao.inserir(fornecedor);
    	
    	fornecedor.setId(2);
    	fornecedor.setNome("Amazon");
    	fornecedor.setCnpj("15436940000103");
    	fornecedor.setTelefone("9260 9004");
    	
    	forneDao.atualizar(fornecedor);
    }
}
