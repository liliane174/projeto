package imobiliaria;

import java.util.ArrayList;

public class DadosClientes {
	private ArrayList<Cliente> vetCli = new ArrayList<Cliente>();
	
	public boolean cadastrarProp(ClienteProp cp) {
		if (cp != null) {
			vetCli.add(new ClienteProp(cp));
			System.out.println("Total de clientes: " + vetCli.size());
			return true;
		}
		else return false;
	}
	
	public boolean cadastrarUsuario(ClienteUsuario uc) {
		if (uc != null) {
			vetCli.add(new ClienteUsuario(uc));
			System.out.println("Total de clientes: " + vetCli.size());
			return true;
		}
		else return false;
	}
	
	public void listar(){
		for (Cliente obj: vetCli) {
			obj.mostraDadosPessoais();
		}
	}
	
	// Este método retorna o objeto Cliente caso encontrado, ou null, caso não encontrado
	public Cliente buscar(String cpf) {
		Cliente c = null;
		for (Cliente obj: vetCli) {
			if (obj.getCpf().equals(cpf)) {
				c = obj;
				break;
			}
		}
		return c;
	}
	
	//este método usa o método buscar já implementado
	public boolean excluir(String cpf){
		Cliente c = buscar(cpf);
		if (c != null) {
			vetCli.remove(c);
			return true;
		}
		else
			return false;
	}
}
