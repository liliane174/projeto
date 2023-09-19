package imobiliaria;

public class ClienteProp extends Cliente {
	private String dataPrimCadastro;
	private Imovel imv;
	
	public ClienteProp(ClienteProp pc) {
		super(pc.getNome(), pc.getCpf(), pc.getEndereco(), pc.getTelefone(), pc.getEmail(), pc.getSexo(), pc.getEstadoCivil(), pc.getProfissao());
		setDataPrimCadastro(pc.getDataPrimCadastro());
	}

	public ClienteProp (String n, String cpf, String e, String t, String em, String sx, int ec, String p, String datapc) {
		super(n, cpf, e, t, em, sx, ec, p);
		setDataPrimCadastro(datapc);
	}
	

	public String getDataPrimCadastro() {
		return dataPrimCadastro;
	}

	public boolean setDataPrimCadastro(String dataPrimCadastro) {
		if (dataPrimCadastro.length() > 0) {
			this.dataPrimCadastro = dataPrimCadastro;
			return true;
		}
	else
		return false;
	}
	
	public Imovel getImv() {
		return imv;
	}


	public void setImv(Imovel imv) {
		this.imv = imv;
	}
	
	public void mostrarDados() {
		super.mostraDadosPessoais();
			System.out.println("Data do primeiro cadastro: " + dataPrimCadastro);
			System.out.println("Imóvel Cadastrado: " + imv);
		}

}
