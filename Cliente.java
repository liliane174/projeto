package imobiliaria;

public class Cliente extends Pessoa {
	private String email;
	private String sexo;
	private int estadoCivil;
	private String profissao;
	
	public Cliente(String n, String cpf) {
		super(n, cpf);
	}
	
	public Cliente() {
		
	}
	
	public Cliente(String n, String cpf, String e, String t, String em, String sx, int ec, String p) {
		super(n, cpf, e, t);
		setEmail(em);
		setSexo(sx);
		setEstadoCivil(ec);
		setProfissao(p);
	}
	
	public String getEmail() {
		return email;
	}
	
	public boolean setEmail(String email) {
		if (email.length() > 0) {
			this.email = email;
			return true;
		}
	else
		return false;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public boolean setSexo(String sexo) {
		if ((sexo == "M") || (sexo == "m") || (sexo == "F") || (sexo == "f")) {
			this.sexo = sexo;
			return true;
		}
		else
			return false;
	}
	
	public int getEstadoCivil() {
		return estadoCivil;
	}
	
	// Legenda: 1 = solteiro; 2 = casado; 3 = separado; 4 = divorciado; 5 = viuvo
	public boolean setEstadoCivil(int estadoCivil) {
		if ((estadoCivil >= 1) && (estadoCivil <= 5)) {
			this.estadoCivil = estadoCivil;
			return true;
		}
		else
			return false;
	}
	
	public String getProfissao() {
		return profissao;
	}
	
	public boolean setProfissao(String profissao) {
		if (profissao.length() > 0) {
			this.profissao = profissao;
			return true;
		}
	else
		return false;
	}
	
	public void mostraDadosPessoais() {
		System.out.println("\nNome: " + getNome());
		System.out.println("CPF: " + getCpf());
		System.out.println("Endereço: " + getEndereco());
		System.out.println("Telefone: " + getTelefone());
		System.out.println("Email: " + email);
		System.out.println("Sexo: " + sexo);
		System.out.println("Estado Cívil: " + estadoCivil);
		System.out.println("Profissão: " + profissao);
	}

}
