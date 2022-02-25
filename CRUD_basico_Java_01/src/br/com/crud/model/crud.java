package br.com.crud.model;

import java.util.Date;

public class crud {
     private int codigo;
     private String dados_inseridos;
     private Date data_inserida;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDados_inseridos() {
		return dados_inseridos;
	}
	public void setDados_inseridos(String dados_inseridos) {
		this.dados_inseridos = dados_inseridos;
	}
	public Date getData_inserida() {
		return data_inserida;
	}
	public void setData_inserida(Date data_inserida) {
		this.data_inserida = data_inserida;
	}
     
}
