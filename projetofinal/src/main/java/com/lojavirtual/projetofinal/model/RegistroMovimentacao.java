package com.lojavirtual.projetofinal.model;

public class RegistroMovimentacao {
	
	private int id_movimentacao;
	private String tipo;
	private int quantidade;
	private String data;
	private Produto produto;
	private Fornecedor fornecedor;
	
	public RegistroMovimentacao(String tipo, int quantidade, String data, Produto produto, Fornecedor fornecedor) {
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.data = data;
		this.produto = produto;
		this.fornecedor = fornecedor;
	}
	
	public int getIdMovimentacao() {
		return this.id_movimentacao;
	}
	
	public void setIdMovimentacao(int id_movimentacao) {
		this.id_movimentacao = id_movimentacao;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getData() {
		return this.data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public Produto getProduto() {
		return this.produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
