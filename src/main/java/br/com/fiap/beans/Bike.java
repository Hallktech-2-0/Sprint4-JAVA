package br.com.fiap.beans;

public class Bike {
	
	private String chassi;
    private String marca;
    private String modelo;
    private String cor;
    private double aro;
    private String quadro;
    private double peso;
    private String modalidade;
    private double valorTotal;
    private String clienteCpf;
    
    
    
	public Bike() {
		super();
	}



	public Bike(String chassi, String marca, String modelo, String cor, double aro, String quadro, double peso,
			String modalidade, double valorTotal, String clienteCpf) {
		super();
		this.chassi = chassi;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.aro = aro;
		this.quadro = quadro;
		this.peso = peso;
		this.modalidade = modalidade;
		this.valorTotal = valorTotal;
		this.clienteCpf = clienteCpf;
	}



	public String getChassi() {
		return chassi;
	}



	public void setChassi(String chassi) {
		this.chassi = chassi;
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



	public String getCor() {
		return cor;
	}



	public void setCor(String cor) {
		this.cor = cor;
	}



	public double getAro() {
		return aro;
	}



	public void setAro(double aro) {
		this.aro = aro;
	}



	public String getQuadro() {
		return quadro;
	}



	public void setQuadro(String quadro) {
		this.quadro = quadro;
	}



	public double getPeso() {
		return peso;
	}



	public void setPeso(double peso) {
		this.peso = peso;
	}



	public String getModalidade() {
		return modalidade;
	}



	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}



	public double getValorTotal() {
		return valorTotal;
	}



	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}



	public String getClienteCpf() {
		return clienteCpf;
	}



	public void setClienteCpf(String clienteCpf) {
		this.clienteCpf = clienteCpf;
	}



	@Override
	public String toString() {
		return "Bike [chassi=" + chassi + ", marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", aro=" + aro
				+ ", quadro=" + quadro + ", peso=" + peso + ", modalidade=" + modalidade + ", valorTotal=" + valorTotal
				+ ", clienteCpf=" + clienteCpf + "]";
	}



    
    
}