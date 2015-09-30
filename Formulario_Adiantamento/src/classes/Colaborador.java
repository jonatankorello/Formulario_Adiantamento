package classes;

public class Colaborador extends Entidade {

	String cpf;
	
	public Colaborador(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getCpf(){
		return cpf;
	}
	
}

