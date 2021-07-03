package br.com.motos.api.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * motoModelo
 */
@Entity
@Table (name="motos")
public class MotoModelo {

  // Atributos
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int codigo;
  private String marca;
  private String modelo;
  private int ano;
  private int cilindrada;

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return this.ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getCilindrada() {
		return this.cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}


  // Get e Set



  
}