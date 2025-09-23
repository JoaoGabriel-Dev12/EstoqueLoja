package com.lojavirtual.projetofinal;

import java.sql.Connection;

import com.lojavirtual.projetofinal.connection.ConnectionFactory;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        
    	ConnectionFactory connection = new ConnectionFactory();
    	Connection con = connection.createConnectionMySql();
    	
    	if(con != null) {
    		System.out.println("Conexão obtida com sucesso!");
    		con.close();
    	}
    }
}
