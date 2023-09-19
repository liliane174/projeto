package imobiliaria;

public class Funcionario extends Pessoa {
	private String telCelular;
	private String dataIngresso;
	private float salario;
	private String cargo;
	private String usuario;
	private String senha;
	
	public Funcionario(String n, String cpf, String e, String t, String tc, String ding, float sal, 
							String cargo, String us, String se) {
		super(n, cpf, e, t);
		setTelCelular(tc);
		setDataIngresso(ding);
		setSalario(sal);
		setCargo(cargo);
		setUsuario(us);
		setSenha(se);
	}
	
	public String getTelCelular() {
		return telCelular;
	}
	
	public boolean setTelCelular(String telCelular) {
		if (telCelular.length() > 0) {
			this.telCelular = telCelular;
			return true;
		}
	else
		return false;
	}
	
	public String getDataIngresso() {
		return dataIngresso;
	}
	
	public boolean setDataIngresso(String dataIngresso) {
		if (dataIngresso.length() > 0) {
			this.dataIngresso = telCelular;
			return true;
		}
	else
		return false;
	}
	
	public float getSalario() {
		return salario;
	}
	
	public boolean setSalario(float salario) {
		if (salario > 0) {
			this.salario = salario;
			return true;
		}
		return false;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public boolean setCargo(String cargo) {
		if (cargo.length() > 0) {
			this.cargo = cargo;
			return true;
		}
	else
		return false;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public boolean setUsuario(String usuario) {
		if (usuario.length() > 0) {
			this.usuario = usuario;
			return true;
		}
	else
		return false;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public boolean setSenha(String senha) {
		if (senha.length() > 0) {
			this.senha = senha;
			return true;
		}
	else
		return false;
	}
	
	// Método para calcular salário
	public float calcularSalario() {
		return salario;
	}
	
	public void mostraDadosPessoais() {
		System.out.println("\nNome: " + getNome());
		System.out.println("CPF: " + getCpf());
		System.out.println("Endereço: " + getEndereco());
		System.out.println("Telefone: " + getTelefone());
		System.out.println("Telefone celular: " + telCelular);
		System.out.println("Data de Ingresso: " + dataIngresso);
		System.out.println("Salario: " + salario);
		System.out.println("Cargo: " + cargo);
		System.out.println("Usuario: " + usuario);
		System.out.println("Senha: " + senha);
	}
}
