package imobiliaria;

public class ClienteUsuario extends Cliente {
	private String nomeIndica;
	private String cpfIndica;
	
	public ClienteUsuario(ClienteUsuario uc) {
		super(uc.getNome(), uc.getCpf(), uc.getEndereco(), uc.getTelefone(), uc.getEmail(), uc.getSexo(), uc.getEstadoCivil(), uc.getProfissao());
		setNomeIndica(uc.getNomeIndica());
		setCpfIndica(uc.cpfIndica);
	}
	
	public ClienteUsuario (String n, String cpf, String e, String t, String em, String sx, int ec, String p, String ni, String cpfi) {
		super(n, cpf, e, t, em, sx, ec, p);
		setNomeIndica(ni);
		setCpfIndica(cpfi);
	}
	
	public String getNomeIndica() {
		return nomeIndica;
	}

	public boolean setNomeIndica(String nomeIndica) {
		if (nomeIndica.length() > 0) {
			this.nomeIndica = nomeIndica;
			return true;
		}
	else
		return false;
	}

	public String getCpfIndica() {
		return cpfIndica;
	}

	public boolean setCpfIndica(String cpfIndica) {
		if (super.VerificaCpf(cpfIndica) == true) {
			this.cpfIndica = cpfIndica;
			return true;
		}
		else
			return false;
	}
	
	public void mostrarDados() {
		super.mostraDadosPessoais();
			System.out.println("Nome da pessoa que o indicou: " + nomeIndica);
			System.out.println("CPF da pessoa que o indicou: " + cpfIndica);
		}
}
