package br.imd.BuscaSaude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class UnidadeSaude implements Serializable {
	
	private String nome;
	private String endereco;
	private String bairro;
	private int id;
	private ArrayList<String> especialidades;

	
	public UnidadeSaude(String nome, String endereco, String bairro, int id, ArrayList<String> especialidades) {
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
		this.id = id;
		this.especialidades = especialidades;
	}
	
	public UnidadeSaude()
	{
		this.nome = "";
		this.endereco = "";
		this.bairro = "";
		this.id = -1;
		this.especialidades = new ArrayList<String>();
	}

	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getBairro() {
		return bairro;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public ArrayList<String> getEspecialidades() {
		return especialidades;
	}


	public void setEspecialidades(ArrayList<String> especialidades) {
		this.especialidades = especialidades;
	}
	
	public void addEspecialidade(String especialidade){
		especialidades.add(especialidade);
	}
	
	public String toString(){
		
		String atributos = "";

		atributos += "ID: " + this.id + "\n";
		atributos += "Nome: " + this.nome + "\n";
		atributos += "Endereco: " + this.endereco + "\n";
		atributos += "Bairro: " + this.bairro + "\n";
		atributos += "Especialidades: ";
		
		Iterator<String> inter1 = especialidades.iterator();
		
		boolean primeiro = true;
		
		while (inter1.hasNext()){
			
			if( primeiro ){
				atributos += inter1.next();
				primeiro = false;
			}
			else
				atributos +=  ", " + inter1.next();
			
		}
		
		return atributos;
	}

}
