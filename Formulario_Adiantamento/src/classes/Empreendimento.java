package classes;

public class Empreendimento extends Entidade {

	String sigla;
	
	public Empreendimento(String nome, String sigla){
		this.nome = nome;
		this.sigla = sigla;
	}
	
	public String getSigla(){
		return sigla;
	}
	
}
