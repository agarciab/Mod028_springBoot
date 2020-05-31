package com.vn.dto;

public class Coche {

	
	private String marca;
	
	private String modelo;
	
	private int potencia;
	
	public Coche(String marca, String modelo, int potencia) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.potencia = potencia;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	
}
