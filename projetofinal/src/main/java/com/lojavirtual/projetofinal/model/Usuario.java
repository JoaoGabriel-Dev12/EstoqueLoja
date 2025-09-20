package com.lojavirtual.projetofinal.model;

public class Usuario {
	
	private String usuario;
	private String senha;
	
	public Usuario(String usuario, String senha) {
		
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
