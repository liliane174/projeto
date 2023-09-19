package imobiliaria;

public class Corretor extends Funcionario {
	private static float PorcComissao = 0.05f;
	private String dataCorretor;
	private boolean curso;
	private float comissaoTotal=0;
	private int numVendas = 0;
	
	public Corretor(Corretor c) {
		super(c.getNome(), c.getCpf(), c.getEndereco(), c.getTelefone(), c.getTelCelular(), c.getDataIngresso(), c.getSalario(), c.getCargo(), c.getUsuario(), c.getSenha());
		setDataCorretor(c.getDataCorretor());
		setCurso(c.isCurso());	
		}

	public Corretor (String n, String cpf, String e, String t, String tc, String ding, float sal, 
						String cargo, String us, String se, String dc, boolean curso) {
		super(n, cpf, e, t, tc, ding, sal, cargo, us, se);
		setDataCorretor(dc);
		setCurso(curso);
	}

	public static float getPorcComissao() {
		return PorcComissao;
	}
	
	public static boolean setPorcComissao(float porcComissao) {
		if (porcComissao > 0) {
			PorcComissao = porcComissao;
			return true;
		}
		else
			return false;
		
	}
	
	public String getDataCorretor() {
		return dataCorretor;
	}
	
	public boolean setDataCorretor(String dataCorretor) {
		if (dataCorretor.length() > 0) {
			this.dataCorretor = dataCorretor;
			return true;
		}
	else
		return false;
	}
	
	public boolean isCurso() {
		return curso;
	}
	
	public void setCurso(boolean curso) {
		this.curso = curso;
	}
	
	// M�todo para contabilizar a qtd de vendas e alugueis realizadas pelo corretor
	public int numVendas() {
		return numVendas += 1;
		
	}
	
	public int getNumVendas() {
		return numVendas;
	}

	public float getComissaoTotal() {
		return comissaoTotal;
	}

	public void ComissaoTotal(float valor) {
		comissaoTotal += (valor * PorcComissao);
	}
	
	// M�todo para zerar o total de vendas e o numero de vendas. Deve ser usada no come�o do m�s!
	public void zerarVendas() {
		numVendas = 0;
		comissaoTotal = 0;
	}
	
	// M�todo para calcular salario refatorado
	public float calcularSalario() {
		return super.calcularSalario() + comissaoTotal;
	}
	
	public void mostrarDados() {
		System.out.println("\nNome: " + getNome());
		System.out.println("CPF: " + getCpf());
		System.out.println("Endere�o: " + getEndereco());
		System.out.println("Telefone: " + getTelefone());
		System.out.println("Telefone celular: " + getTelCelular());
		System.out.println("Data de Ingresso: " + getDataIngresso());
		System.out.println("Salario: " + calcularSalario());
		System.out.println("Cargo: " + getCargo());
		System.out.println("Usuario: " + getUsuario());
		System.out.println("Senha: " + getSenha());
		System.out.println("Data de ingresso na imobili�rio: " + dataCorretor);
		System.out.println("Possui cursos: " + curso);
		System.out.println("N�mero de vendas no m�s corrente: " + numVendas);
		System.out.println("Comiss�o total no m�s corrente: " + comissaoTotal);
	}
	
}