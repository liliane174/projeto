package imobiliaria;

public class Casa extends Imovel {
	private int qtdQuartos;
	private int qtdSuites;
	private int qtdSalaEstar;
	private int numVaga;
	private boolean armario;
	private String descricao;
	private boolean condominio;
	private boolean piscina;
	
	public Casa(Casa c) {
		super(c.getCodigo(), c.getStatus(), c.getArea(), c.getDataConstrucao(), c.getEndereco(), c.getBairro(), c.getValorSuge(), c.getValorReal(), c.getValorImob(), c.getCpfProp(), c.getDataEntrada(), c.isRetirado());
		setQtdQuartos(c.getQtdQuartos());
		setQtdSuites(c.getQtdSuites());
		setQtdSalaEstar(c.getQtdSalaEstar());
		setNumVaga(c.getNumVaga());
		setArmario(c.isArmario());
		setDescricao(c.getDescricao());
		setCondominio(c.isCondominio());
		setPiscina(c.isPiscina());
	}
	
	public Casa (String cod, int s, float a, String dc, String e, String b, float vs, float vr, float vi, String cp, String de, boolean ret, 
					int qtdq, int qtdsu, int qtdsala, int numvg, boolean arm, String desc, boolean cond, boolean pisc) {
		super(cod, s, a, dc, e, b, vs, vr, vi, cp, de, ret);
		setQtdQuartos(qtdq);
		setQtdSuites(qtdsu);
		setQtdSalaEstar(qtdsala);
		setNumVaga(numvg);
		setArmario(arm);
		setDescricao(desc);
		setCondominio(cond);
		setPiscina(pisc);
	}
	
	public int getQtdQuartos() {
		return qtdQuartos;
	}
	
	public boolean setQtdQuartos(int qtdQuartos) {
		if (qtdQuartos <= 0)
			return false;
		else {
			this.qtdQuartos = qtdQuartos;
			return true;
		}
	}
	
	public int getQtdSuites() {
		return qtdSuites;
	}
	
	public boolean setQtdSuites(int qtdSuites) {
		if (qtdSuites < 0)
			return false;
		else {
			this.qtdSuites = qtdSuites;
			return true;
		}
	}
	
	public int getQtdSalaEstar() {
		return qtdSalaEstar;
	}
	
	public boolean setQtdSalaEstar(int qtdSalaEstar) {
		if (qtdSalaEstar < 0)
			return false;
		else {
			this.qtdSalaEstar = qtdSalaEstar;
			return true;
		}
	}
	
	public int getNumVaga() {
		return numVaga;
	}
	
	
	public boolean setNumVaga(int numVaga) {
		if (numVaga < 0)
			return false;
		else {
			this.numVaga = numVaga;
			return true;
		}
	}

	public boolean isArmario() {
		return armario;
	}
	
	public void setArmario(boolean armario) {
		this.armario = armario;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public boolean setDescricao(String descricao) {
		if (descricao.length() > 0) {
			this.descricao = descricao;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isCondominio() {
		return condominio;
	}
	
	public void setCondominio(boolean condominio) {
		this.condominio = condominio;
	}
	
	public boolean isPiscina() {
		return piscina;
	}
	
	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}
	
	public void mostrarDados() {
		super.mostrarDados();
		System.out.println("Quantidade de quartos: " + qtdQuartos);
		System.out.println("Quantidade de suítes: " + qtdSuites);
		System.out.println("Quantidade de salas de estar: " + qtdSalaEstar);
		System.out.println("Número de vagas: " + numVaga);
		System.out.println("Armários: " + armario);
		System.out.println("Descrição: " + descricao);
		System.out.println("Condomínio: " + condominio);
		System.out.println("Piscina: " + piscina);
	}
	
	public String toString() {
		return String.format("\nCódigo: %s\nStatus: %s\nÁrea: %s\nData da construção: %s\nEndereço: %s\nBairro: %s\nValor Sugerido: %s\nValor acordado: %s\nValor repassado para imobiliária: %s\n"
				+ "CPF do Proprietário: %s\nImóvel retirado: %s\nQuantidade de quartos: %s\nQuantidade de suítes: %s\nQuantidade de salas de estar: %s\nNúmero de vagas: %s\nArmários: %s\nDescrição: %s\n"
				+ "Tem condomínio:%s\nTem Piscina: %s\n=========================================================\n", super.getCodigo(), super.getStatus(), super.getArea(), super.getDataConstrucao(),
				super.getEndereco(), super.getBairro(), super.getValorSuge(), super.getValorReal(), super.getValorImob(), super.getCpfProp(), super.isRetirado(), qtdQuartos, qtdSuites, qtdSalaEstar, numVaga, armario, descricao, condominio, piscina);
	}
}
