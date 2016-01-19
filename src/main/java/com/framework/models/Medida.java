package com.framework.models;

public class Medida {
	private Double valor;
	private TipoMedida tipoMedida;
	
	public Medida() {
		// TODO Auto-generated constructor stub
	}

	public Medida(String valor, TipoMedida tipoMedida) {
		this.valor = Double.valueOf(Double.parseDouble(valor));
		this.tipoMedida = tipoMedida;
	}

	public TipoMedida getTipoMedida() {
		return this.tipoMedida;
	}

	public Double getValor() {
		return this.valor;
	}

	public String getDescription() {
		return toString();
	}

	public String toString() {
		return this.valor.toString() + "-" + getTipoMedida().getSimbolo();
	}
}
