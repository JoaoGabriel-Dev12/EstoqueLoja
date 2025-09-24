package com.lojavirtual.projetofinal;

import com.lojavirtual.projetofinal.dao.UsuarioDAO;
import com.lojavirtual.projetofinal.model.Usuario;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        
    	// Testes de uso!
    	
    	UsuarioDAO userDao = new UsuarioDAO();
    	
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
    }
}
