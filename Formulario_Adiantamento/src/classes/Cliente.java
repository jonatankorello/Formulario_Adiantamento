package classes;

public class Cliente extends Entidade {
	
	String cpf;
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getCpf(){
		return cpf;
	}
	
}
