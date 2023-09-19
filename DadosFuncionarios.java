package imobiliaria;

import java.util.ArrayList;

public class DadosFuncionarios {
	private ArrayList<Funcionario> vetFunc = new ArrayList<Funcionario>();
	
	public boolean cadastrar(Corretor c) {
		if (c != null) {
			vetFunc.add(new Corretor(c));
			System.out.println("Total de funcion�rios: " + vetFunc.size());
			return true;
		}
		else return false;
	}
	
	public void listar(){
		for (Funcionario obj: vetFunc) {
			obj.mostraDadosPessoais();
		}
	}
	
	// Este m�todo retorna o objeto Funcion�rio caso encontrado, ou null, caso n�o encontrado
	public Funcionario buscar(String cpf) {
		Funcionario f = null;
		for (Funcionario obj: vetFunc) {
			if (obj.getCpf().equals(cpf)) {
				f = obj;
				break;
			}
		}
		return f;
	}
	
	// Este m�todo usa o m�todo buscar j� implementado
	public boolean excluir(String cpf){
		Funcionario f = buscar(cpf);
		if (f != null) {
			vetFunc.remove(f);
			return true;
		}
		else
			return false;
	}
}
